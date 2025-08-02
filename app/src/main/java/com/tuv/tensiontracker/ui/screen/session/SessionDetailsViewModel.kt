package com.tuv.tensiontracker.ui.screen.session

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuv.tensiontracker.domain.model.SessionWithDetails
import com.tuv.tensiontracker.domain.model.UserPreferences
import com.tuv.tensiontracker.domain.usecase.session.GetSessionsWithDetailsUseCase
import com.tuv.tensiontracker.domain.repository.UserPreferencesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SessionDetailsViewModel @Inject constructor(
    private val getSessionsWithDetailsUseCase: GetSessionsWithDetailsUseCase,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(SessionDetailsUiState())
    val uiState: StateFlow<SessionDetailsUiState> = _uiState.asStateFlow()
    
    fun loadSessionDetails(sessionId: Long) {
        combine(
            getSessionsWithDetailsUseCase(),
            userPreferencesRepository.getPreferences()
        ) { sessions, preferences ->
            val session = sessions.find { it.session.id == sessionId }
            _uiState.value = _uiState.value.copy(
                sessionWithDetails = session,
                userPreferences = preferences,
                isLoading = false,
                error = if (session == null) "Session not found" else null
            )
        }.launchIn(viewModelScope)
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}

data class SessionDetailsUiState(
    val sessionWithDetails: SessionWithDetails? = null,
    val userPreferences: UserPreferences = UserPreferences(),
    val isLoading: Boolean = true,
    val error: String? = null
)