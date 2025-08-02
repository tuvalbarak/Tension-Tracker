package com.tuv.tensiontracker.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuv.tensiontracker.domain.model.SessionWithDetails
import com.tuv.tensiontracker.domain.usecase.session.GetSessionsWithDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSessionsWithDetailsUseCase: GetSessionsWithDetailsUseCase
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    
    init {
        loadRecentSessions()
    }
    
    private fun loadRecentSessions() {
        getSessionsWithDetailsUseCase()
            .map { sessions -> sessions.take(5) } // Take only the 5 most recent
            .map { recentSessions ->
                _uiState.value.copy(
                    recentSessions = recentSessions,
                    isLoading = false
                )
            }
            .launchIn(viewModelScope)
    }
}

data class HomeUiState(
    val recentSessions: List<SessionWithDetails> = emptyList(),
    val isLoading: Boolean = true
)