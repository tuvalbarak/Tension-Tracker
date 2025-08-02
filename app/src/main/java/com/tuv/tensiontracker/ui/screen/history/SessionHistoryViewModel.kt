package com.tuv.tensiontracker.ui.screen.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tuv.tensiontracker.domain.model.SessionWithDetails
import com.tuv.tensiontracker.domain.model.StringType
import com.tuv.tensiontracker.domain.usecase.session.GetSessionsWithDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class SessionHistoryViewModel @Inject constructor(
    private val getSessionsWithDetailsUseCase: GetSessionsWithDetailsUseCase
) : ViewModel() {
    
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()
    
    private val _selectedStringTypeFilter = MutableStateFlow<StringType?>(null)
    val selectedStringTypeFilter: StateFlow<StringType?> = _selectedStringTypeFilter.asStateFlow()
    
    private val _sortOrder = MutableStateFlow(SortOrder.DATE_DESC)
    val sortOrder: StateFlow<SortOrder> = _sortOrder.asStateFlow()
    
    private val _uiState = MutableStateFlow(SessionHistoryUiState())
    val uiState: StateFlow<SessionHistoryUiState> = _uiState.asStateFlow()
    
    private val allSessions = getSessionsWithDetailsUseCase()
    
    init {
        setupSessionFiltering()
    }
    
    private fun setupSessionFiltering() {
        // Combine search query, filter, and sort preferences with session data
        combine(
            allSessions,
            _searchQuery.debounce(300).distinctUntilChanged(),
            _selectedStringTypeFilter,
            _sortOrder
        ) { sessions, query, typeFilter, sortOrder ->
            _uiState.value = _uiState.value.copy(isLoading = false)
            
            var filteredSessions = sessions
            
            // Apply text search
            if (query.isNotBlank()) {
                filteredSessions = filteredSessions.filter { session ->
                    session.mainString?.name?.contains(query, ignoreCase = true) == true ||
                    session.crossString?.name?.contains(query, ignoreCase = true) == true ||
                    session.session.locationInstalled?.contains(query, ignoreCase = true) == true ||
                    session.mainString?.brand?.contains(query, ignoreCase = true) == true ||
                    session.crossString?.brand?.contains(query, ignoreCase = true) == true
                }
            }
            
            // Apply string type filter
            typeFilter?.let { type ->
                filteredSessions = filteredSessions.filter { session ->
                    session.mainString?.type == type || session.crossString?.type == type
                }
            }
            
            // Apply sorting
            filteredSessions = when (sortOrder) {
                SortOrder.DATE_DESC -> filteredSessions.sortedByDescending { it.session.dateStrung }
                SortOrder.DATE_ASC -> filteredSessions.sortedBy { it.session.dateStrung }
                SortOrder.TENSION_DESC -> filteredSessions.sortedByDescending { it.session.mainTension.value }
                SortOrder.TENSION_ASC -> filteredSessions.sortedBy { it.session.mainTension.value }
                SortOrder.STRING_NAME -> filteredSessions.sortedBy { it.mainString?.name ?: "" }
            }
            
            SessionHistoryUiState(
                sessions = filteredSessions,
                isLoading = false,
                isEmpty = sessions.isEmpty(),
                isFiltered = query.isNotBlank() || typeFilter != null,
                filteredCount = filteredSessions.size,
                totalCount = sessions.size
            )
        }.onEach { state ->
            _uiState.value = state
        }.launchIn(viewModelScope)
    }
    
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
    
    fun updateStringTypeFilter(stringType: StringType?) {
        _selectedStringTypeFilter.value = stringType
    }
    
    fun updateSortOrder(sortOrder: SortOrder) {
        _sortOrder.value = sortOrder
    }
    
    fun clearFilters() {
        _searchQuery.value = ""
        _selectedStringTypeFilter.value = null
        _sortOrder.value = SortOrder.DATE_DESC
    }
    
    fun refresh() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isRefreshing = true)
            // In a real app, you might want to refresh data from network
            // For now, we just reset the refreshing state
            _uiState.value = _uiState.value.copy(isRefreshing = false)
        }
    }
}

data class SessionHistoryUiState(
    val sessions: List<SessionWithDetails> = emptyList(),
    val isLoading: Boolean = true,
    val isRefreshing: Boolean = false,
    val isEmpty: Boolean = false,
    val isFiltered: Boolean = false,
    val filteredCount: Int = 0,
    val totalCount: Int = 0,
    val errorMessage: String? = null
)

enum class SortOrder(val displayName: String) {
    DATE_DESC("Newest First"),
    DATE_ASC("Oldest First"),
    TENSION_DESC("Highest Tension"),
    TENSION_ASC("Lowest Tension"),
    STRING_NAME("String Name")
}