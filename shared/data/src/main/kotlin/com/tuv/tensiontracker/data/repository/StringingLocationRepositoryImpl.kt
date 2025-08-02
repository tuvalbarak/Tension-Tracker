package com.tuv.tensiontracker.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.tuv.tensiontracker.data.database.TensionTrackerDatabase
import com.tuv.tensiontracker.data.mapper.DomainMapper
import com.tuv.tensiontracker.domain.model.StringingLocation
import com.tuv.tensiontracker.domain.repository.StringingLocationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock

class StringingLocationRepositoryImpl(
    private val database: TensionTrackerDatabase
) : StringingLocationRepository {
    
    private val queries = database.stringingLocationsQueries
    
    override suspend fun insertOrIncrementLocation(locationName: String) = withContext(Dispatchers.IO) {
        val now = Clock.System.now()
        queries.insertOrIncrementLocation(
            location_name = locationName,
            last_used = now.toEpochMilliseconds(),
            created_at = now.toEpochMilliseconds()
        )
    }
    
    override suspend fun deleteLocation(locationId: Long) = withContext(Dispatchers.IO) {
        queries.deleteLocation(locationId)
    }
    
    override fun getAllLocations(): Flow<List<StringingLocation>> {
        return queries.getAllLocations()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { dbLocations ->
                dbLocations.map { DomainMapper.mapStringLocation(it) }
            }
    }
    
    override suspend fun searchLocations(query: String): List<StringingLocation> = withContext(Dispatchers.IO) {
        queries.searchLocations(query).executeAsList()
            .map { DomainMapper.mapStringLocation(it) }
    }
    
    override suspend fun getTopLocations(limit: Int): List<StringingLocation> = withContext(Dispatchers.IO) {
        queries.getTopLocations(limit.toLong()).executeAsList()
            .map { DomainMapper.mapStringLocation(it) }
    }
}