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
import com.tuv.tensiontracker.domain.usecase.session.UpdateStringingSessionUseCase
import com.tuv.tensiontracker.domain.usecase.session.GetSessionsWithDetailsUseCase
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
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject

@HiltViewModel
class EditSessionViewModel @Inject constructor(
    private val updateSessionUseCase: UpdateStringingSessionUseCase,
    private val getSessionsWithDetailsUseCase: GetSessionsWithDetailsUseCase,
    private val getStringCatalogUseCase: GetStringCatalogUseCase,
    private val userPreferencesRepository: UserPreferencesRepository,
    private val locationRepository: StringingLocationRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(EditSessionUiState())
    val uiState: StateFlow<EditSessionUiState> = _uiState.asStateFlow()
    
    private var originalSession: StringingSession? = null
    
    fun loadSession(sessionId: Long) {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)
                
                // Load session details
                val sessionWithDetails = getSessionsWithDetailsUseCase()
                    .first()
                    .find { it.session.id == sessionId }
                
                if (sessionWithDetails == null) {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = "Session not found"
                    )
                    return@launch
                }
                
                originalSession = sessionWithDetails.session
                
                // Load user preferences and strings
                userPreferencesRepository.getPreferences()
                    .onEach { preferences ->
                        _uiState.value = _uiState.value.copy(tensionUnit = preferences.tensionUnit)
                    }
                    .launchIn(this)
                
                // Load strings
                getStringCatalogUseCase.ensureInitialized()
                getStringCatalogUseCase.getAllStrings()
                    .onEach { strings ->
                        _uiState.value = _uiState.value.copy(
                            availableStrings = strings,
                            isLoadingStrings = false
                        )
                    }
                    .launchIn(this)
                
                // Load recent locations
                val recentLocations = locationRepository.getTopLocations(10)
                
                // Pre-populate form with existing session data
                val session = sessionWithDetails.session
                val userPrefs = userPreferencesRepository.getPreferences().first()
                
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    sessionId = sessionId,
                    dateStrung = session.dateStrung,
                    selectedMainString = sessionWithDetails.mainString,
                    selectedCrossString = sessionWithDetails.crossString,
                    isHybrid = session.isHybrid,
                    mainTensionInput = session.mainTension.convertTo(userPrefs.tensionUnit).value.toString(),
                    crossTensionInput = session.crossTension?.convertTo(userPrefs.tensionUnit)?.value?.toString() ?: "",
                    pricePaidInput = session.pricePaid?.toString() ?: "",
                    locationInput = session.locationInstalled ?: "",
                    hoursUntilBreakInput = session.hoursUntilBreak?.toString() ?: "",
                    hoursUntilDeadInput = session.hoursUntilDead?.toString() ?: "",
                    recentLocations = recentLocations
                )
                
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = "Failed to load session: ${e.message}"
                )
            }
        }
    }
    
    fun updateDateStrung(date: Instant) {
        _uiState.value = _uiState.value.copy(dateStrung = date)
    }
    
    fun updateMainString(string: StringModel?) {
        _uiState.value = _uiState.value.copy(selectedMainString = string)
    }
    
    fun updateCrossString(string: StringModel?) {
        _uiState.value = _uiState.value.copy(selectedCrossString = string)
    }
    
    fun updateIsHybrid(isHybrid: Boolean) {
        _uiState.value = _uiState.value.copy(
            isHybrid = isHybrid,
            selectedCrossString = if (!isHybrid) null else _uiState.value.selectedCrossString,
            crossTensionInput = if (!isHybrid) "" else _uiState.value.crossTensionInput
        )
    }
    
    fun updateMainTension(tension: String) {
        _uiState.value = _uiState.value.copy(mainTensionInput = tension)
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
    
    fun updateHoursUntilDead(hours: String) {
        _uiState.value = _uiState.value.copy(hoursUntilDeadInput = hours)
    }
    
    fun updateSession(onSuccess: () -> Unit) {
        val state = _uiState.value
        
        // Validate input
        val validationErrors = validateInput(state)
        if (validationErrors.isNotEmpty()) {
            _uiState.value = state.copy(validationErrors = validationErrors)
            return
        }
        
        _uiState.value = state.copy(isSaving = true, validationErrors = emptySet())
        
        viewModelScope.launch {
            try {
                val mainTension = Tension(
                    value = state.mainTensionInput.toDouble(),
                    unit = state.tensionUnit
                )
                
                val crossTension = if (state.isHybrid && state.crossTensionInput.isNotBlank()) {
                    Tension(
                        value = state.crossTensionInput.toDouble(),
                        unit = state.tensionUnit
                    )
                } else null
                
                val updatedSession = originalSession!!.copy(
                    dateStrung = state.dateStrung,
                    mainStringId = state.selectedMainString!!.id,
                    crossStringId = if (state.isHybrid) state.selectedCrossString?.id else null,
                    mainTension = mainTension,
                    crossTension = crossTension,
                    pricePaid = state.pricePaidInput.toDoubleOrNull(),
                    locationInstalled = state.locationInput.takeIf { it.isNotBlank() },
                    hoursUntilBreak = state.hoursUntilBreakInput.toDoubleOrNull(),
                    hoursUntilDead = state.hoursUntilDeadInput.toDoubleOrNull(),
                    updatedAt = Clock.System.now()
                )
                
                updateSessionUseCase(updatedSession).getOrThrow()
                
                _uiState.value = state.copy(isSaving = false)
                onSuccess()
                
            } catch (e: Exception) {
                _uiState.value = state.copy(
                    isSaving = false,
                    errorMessage = "Failed to update session: ${e.message}"
                )
            }
        }
    }
    
    private fun validateInput(state: EditSessionUiState): Set<EditSessionValidationError> {
        val errors = mutableSetOf<EditSessionValidationError>()
        
        // Main string is required
        if (state.selectedMainString == null) {
            errors.add(EditSessionValidationError.MAIN_STRING_REQUIRED)
        }
        
        // Main tension is required and must be valid
        if (state.mainTensionInput.isBlank()) {
            errors.add(EditSessionValidationError.MAIN_TENSION_REQUIRED)
        } else {
            val mainTension = state.mainTensionInput.toDoubleOrNull()
            if (mainTension == null || mainTension <= 0) {
                errors.add(EditSessionValidationError.MAIN_TENSION_INVALID)
            }
        }
        
        // Cross tension validation (if hybrid)
        if (state.isHybrid && state.crossTensionInput.isNotBlank()) {
            val crossTension = state.crossTensionInput.toDoubleOrNull()
            if (crossTension == null || crossTension <= 0) {
                errors.add(EditSessionValidationError.CROSS_TENSION_INVALID)
            }
        }
        
        // Price validation (if provided)
        if (state.pricePaidInput.isNotBlank()) {
            val price = state.pricePaidInput.toDoubleOrNull()
            if (price == null || price < 0) {
                errors.add(EditSessionValidationError.PRICE_INVALID)
            }
        }
        
        // Hours validation (if provided)
        if (state.hoursUntilBreakInput.isNotBlank()) {
            val hours = state.hoursUntilBreakInput.toDoubleOrNull()
            if (hours == null || hours < 0) {
                errors.add(EditSessionValidationError.HOURS_UNTIL_BREAK_INVALID)
            }
        }
        
        if (state.hoursUntilDeadInput.isNotBlank()) {
            val hours = state.hoursUntilDeadInput.toDoubleOrNull()
            if (hours == null || hours < 0) {
                errors.add(EditSessionValidationError.HOURS_UNTIL_DEAD_INVALID)
            }
        }
        
        return errors
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(errorMessage = null)
    }
}

data class EditSessionUiState(
    val sessionId: Long = 0L,
    val isLoading: Boolean = true,
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
    val hoursUntilDeadInput: String = "",
    val isSaving: Boolean = false,
    val validationErrors: Set<EditSessionValidationError> = emptySet(),
    val errorMessage: String? = null
)

enum class EditSessionValidationError {
    MAIN_STRING_REQUIRED,
    MAIN_TENSION_REQUIRED,
    MAIN_TENSION_INVALID,
    CROSS_TENSION_INVALID,
    PRICE_INVALID,
    HOURS_UNTIL_BREAK_INVALID,
    HOURS_UNTIL_DEAD_INVALID
}