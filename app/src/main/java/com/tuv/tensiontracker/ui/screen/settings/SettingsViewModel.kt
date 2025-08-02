package com.tuv.tensiontracker.ui.screen.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuv.tensiontracker.domain.model.TensionUnit
import com.tuv.tensiontracker.domain.model.UserPreferences
import com.tuv.tensiontracker.domain.repository.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()
    
    init {
        loadPreferences()
    }
    
    private fun loadPreferences() {
        userPreferencesRepository.getPreferences()
            .onEach { preferences ->
                _uiState.value = _uiState.value.copy(
                    preferences = preferences,
                    isLoading = false
                )
            }
            .launchIn(viewModelScope)
    }
    
    fun updateTensionUnit(unit: TensionUnit) {
        viewModelScope.launch {
            userPreferencesRepository.updateTensionUnit(unit)
        }
    }
    
    fun updateRatingScale(scale: UserPreferences.RatingScale) {
        viewModelScope.launch {
            userPreferencesRepository.updateRatingScale(scale)
        }
    }
    
    fun savePreferences(preferences: UserPreferences) {
        viewModelScope.launch {
            userPreferencesRepository.savePreferences(preferences)
        }
    }
    
    fun clearAllData() {
        viewModelScope.launch {
            // TODO: Implement clearing all app data
            // This would involve clearing sessions, feedback, etc.
            userPreferencesRepository.clearAllPreferences()
        }
    }
}

data class SettingsUiState(
    val preferences: UserPreferences = UserPreferences(),
    val isLoading: Boolean = true,
    val showClearDataDialog: Boolean = false
)