package com.tuv.tensiontracker.domain.repository

import com.tuv.tensiontracker.domain.model.UserPreferences
import kotlinx.coroutines.flow.Flow

interface UserPreferencesRepository {
    
    suspend fun savePreferences(preferences: UserPreferences)
    
    fun getPreferences(): Flow<UserPreferences>
    
    suspend fun updateTensionUnit(unit: com.tuv.tensiontracker.domain.model.TensionUnit)
    
    suspend fun updateRatingScale(scale: UserPreferences.RatingScale)
    
    suspend fun clearAllPreferences()
}