package com.tuv.tensiontracker.ui.screen.session

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuv.tensiontracker.domain.model.StringModel
import com.tuv.tensiontracker.domain.model.StringingLocation
import com.tuv.tensiontracker.domain.model.StringingSession
import com.tuv.tensiontracker.domain.model.Tension
import com.tuv.tensiontracker.domain.model.TensionUnit
import com.tuv.tensiontracker.domain.model.UserPreferences
import com.tuv.tensiontracker.domain.repository.StringingLocationRepository
import com.tuv.tensiontracker.domain.repository.UserPreferencesRepository
import com.tuv.tensiontracker.domain.usecase.session.CreateStringingSessionUseCase
import com.tuv.tensiontracker.domain.usecase.strings.GetStringCatalogUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import javax.inject.Inject

@HiltViewModel
class NewSessionViewModel @Inject constructor(
    private val createSessionUseCase: CreateStringingSessionUseCase,
    private val getStringCatalogUseCase: GetStringCatalogUseCase,
    private val userPreferencesRepository: UserPreferencesRepository,
    private val locationRepository: StringingLocationRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(NewSessionUiState())
    val uiState: StateFlow<NewSessionUiState> = _uiState.asStateFlow()
    
    init {
        loadInitialData()
    }
    
    private fun loadInitialData() {
        viewModelScope.launch {
            // Load user preferences for default tension unit
            userPreferencesRepository.getPreferences()
                .onEach { preferences ->
                    _uiState.value = _uiState.value.copy(
                        tensionUnit = preferences.tensionUnit
                    )
                }
                .launchIn(this)
            
            // Ensure string catalog is initialized first
            getStringCatalogUseCase.ensureInitialized()
            
            // Load available strings
            getStringCatalogUseCase.getAllStrings()
                .onEach { strings ->
                    _uiState.value = _uiState.value.copy(
                        availableStrings = strings,
                        isLoadingStrings = false
                    )
                }
                .launchIn(this)
            
            // Load recent locations
            locationRepository.getTopLocations(10)
                .also { locations ->
                    _uiState.value = _uiState.value.copy(
                        recentLocations = locations
                    )
                }
        }
    }
    
    fun updateDateStrung(date: Instant) {
        _uiState.value = _uiState.value.copy(dateStrung = date)
    }
    
    fun updateMainString(string: StringModel?) {
        _uiState.value = _uiState.value.copy(
            selectedMainString = string,
            validationErrors = _uiState.value.validationErrors - NewSessionValidationError.MAIN_STRING_REQUIRED
        )
    }
    
    fun updateCrossString(string: StringModel?) {
        _uiState.value = _uiState.value.copy(selectedCrossString = string)
    }
    
    fun updateMainTension(tension: String) {
        _uiState.value = _uiState.value.copy(
            mainTensionInput = tension,
            validationErrors = if (tension.isNotBlank()) {
                _uiState.value.validationErrors - NewSessionValidationError.MAIN_TENSION_REQUIRED
            } else {
                _uiState.value.validationErrors
            }
        )
    }
    
    fun updateCrossTension(tension: String) {
        _uiState.value = _uiState.value.copy(crossTensionInput = tension)
    }
    
    fun updatePricePaid(price: String) {
        _uiState.value = _uiState.value.copy(pricePaidInput = price)
    }
    
    fun updateLocation(location: String) {
        _uiState.value = _uiState.value.copy(locationInput = location)
    }
    
    fun updateHoursUntilBreak(hours: String) {
        _uiState.value = _uiState.value.copy(hoursUntilBreakInput = hours)
    }
    

    
    fun toggleIsHybrid() {
        _uiState.value = _uiState.value.copy(
            isHybrid = !_uiState.value.isHybrid,
            selectedCrossString = null,
            crossTensionInput = ""
        )
    }
    
    private fun validateForm(): Set<NewSessionValidationError> {
        val errors = mutableSetOf<NewSessionValidationError>()
        val state = _uiState.value
        
        if (state.selectedMainString == null) {
            errors.add(NewSessionValidationError.MAIN_STRING_REQUIRED)
        }
        
        if (state.mainTensionInput.isBlank()) {
            errors.add(NewSessionValidationError.MAIN_TENSION_REQUIRED)
        } else {
            state.mainTensionInput.toDoubleOrNull() ?: run {
                errors.add(NewSessionValidationError.MAIN_TENSION_INVALID)
            }
        }
        
        if (state.isHybrid && state.crossTensionInput.isNotBlank()) {
            state.crossTensionInput.toDoubleOrNull() ?: run {
                errors.add(NewSessionValidationError.CROSS_TENSION_INVALID)
            }
        }
        
        if (state.pricePaidInput.isNotBlank()) {
            state.pricePaidInput.toDoubleOrNull() ?: run {
                errors.add(NewSessionValidationError.PRICE_INVALID)
            }
        }
        
        if (state.hoursUntilBreakInput.isNotBlank()) {
            state.hoursUntilBreakInput.toDoubleOrNull() ?: run {
                errors.add(NewSessionValidationError.HOURS_UNTIL_BREAK_INVALID)
            }
        }
        

        
        return errors
    }
    
    fun saveSession(onSuccess: () -> Unit) {
        viewModelScope.launch {
            val state = _uiState.value
            val errors = validateForm()
            
            if (errors.isNotEmpty()) {
                _uiState.value = state.copy(validationErrors = errors)
                return@launch
            }
            
            _uiState.value = state.copy(isSaving = true)
            
            try {
                val mainTension = Tension(
                    state.mainTensionInput.toDouble(),
                    state.tensionUnit
                )
                
                val crossTension = if (state.isHybrid && state.crossTensionInput.isNotBlank()) {
                    Tension(state.crossTensionInput.toDouble(), state.tensionUnit)
                } else null
                
                val session = StringingSession.createNew(
                    mainStringId = state.selectedMainString!!.id,
                    mainTension = mainTension,
                    crossStringId = state.selectedCrossString?.id,
                    crossTension = crossTension
                ).copy(
                    dateStrung = state.dateStrung,
                    pricePaid = state.pricePaidInput.toDoubleOrNull(),
                    locationInstalled = state.locationInput.takeIf { it.isNotBlank() },
                    hoursUntilBreak = state.hoursUntilBreakInput.toDoubleOrNull()
                )
                
                createSessionUseCase(session).getOrThrow()
                
                _uiState.value = state.copy(isSaving = false)
                onSuccess()
                
            } catch (e: Exception) {
                _uiState.value = state.copy(
                    isSaving = false,
                    errorMessage = "Failed to save session: ${e.message}"
                )
            }
        }
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(errorMessage = null)
    }
}

data class NewSessionUiState(
    val dateStrung: Instant = Clock.System.now(),
    val availableStrings: List<StringModel> = emptyList(),
    val isLoadingStrings: Boolean = true,
    val selectedMainString: StringModel? = null,
    val selectedCrossString: StringModel? = null,
    val isHybrid: Boolean = false,
    val mainTensionInput: String = "",
    val crossTensionInput: String = "",
    val tensionUnit: TensionUnit = TensionUnit.KG,
    val pricePaidInput: String = "",
    val locationInput: String = "",
    val recentLocations: List<StringingLocation> = emptyList(),
    val hoursUntilBreakInput: String = "",
    val isSaving: Boolean = false,
    val validationErrors: Set<NewSessionValidationError> = emptySet(),
    val errorMessage: String? = null
)

enum class NewSessionValidationError {
    MAIN_STRING_REQUIRED,
    MAIN_TENSION_REQUIRED,
    MAIN_TENSION_INVALID,
    CROSS_TENSION_INVALID,
    PRICE_INVALID,
    HOURS_UNTIL_BREAK_INVALID
}