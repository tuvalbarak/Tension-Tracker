package com.tuv.tensiontracker.domain.repository

import com.tuv.tensiontracker.domain.model.StringingLocation
import kotlinx.coroutines.flow.Flow

interface StringingLocationRepository {
    
    suspend fun insertOrIncrementLocation(locationName: String)
    
    suspend fun deleteLocation(locationId: Long)
    
    fun getAllLocations(): Flow<List<StringingLocation>>
    
    suspend fun searchLocations(query: String): List<StringingLocation>
    
    suspend fun getTopLocations(limit: Int): List<StringingLocation>
}