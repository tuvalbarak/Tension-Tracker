package com.tuv.tensiontracker.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.tuv.tensiontracker.data.database.TensionTrackerDatabase
import com.tuv.tensiontracker.domain.model.StringType
import com.tuv.tensiontracker.domain.model.TensionUnit
import com.tuv.tensiontracker.domain.model.UserPreferences
import com.tuv.tensiontracker.domain.repository.UserPreferencesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock

class UserPreferencesRepositoryImpl(
    private val database: TensionTrackerDatabase
) : UserPreferencesRepository {
    
    private val queries = database.userPreferencesQueries
    
    companion object {
        private const val KEY_TENSION_UNIT = "tension_unit"
        private const val KEY_RATING_SCALE = "rating_scale"
        private const val KEY_DEFAULT_STRING_TYPE = "default_string_type"
        private const val KEY_DEFAULT_TENSION = "default_tension"
        private const val KEY_AUTO_BACKUP = "auto_backup"
    }
    
    override suspend fun savePreferences(preferences: UserPreferences) = withContext(Dispatchers.IO) {
        val now = Clock.System.now()
        
        queries.insertOrUpdatePreference(
            preference_key = KEY_TENSION_UNIT,
            preference_value = preferences.tensionUnit.abbreviation,
            updated_at = now.toEpochMilliseconds()
        )
        
        queries.insertOrUpdatePreference(
            preference_key = KEY_RATING_SCALE,
            preference_value = preferences.ratingScale.name,
            updated_at = now.toEpochMilliseconds()
        )
        
        preferences.defaultStringType?.let { type ->
            queries.insertOrUpdatePreference(
                preference_key = KEY_DEFAULT_STRING_TYPE,
                preference_value = type.displayName,
                updated_at = now.toEpochMilliseconds()
            )
        }
        
        preferences.defaultTension?.let { tension ->
            queries.insertOrUpdatePreference(
                preference_key = KEY_DEFAULT_TENSION,
                preference_value = tension.toString(),
                updated_at = now.toEpochMilliseconds()
            )
        }
        
        queries.insertOrUpdatePreference(
            preference_key = KEY_AUTO_BACKUP,
            preference_value = preferences.autoBackup.toString(),
            updated_at = now.toEpochMilliseconds()
        )
    }
    
    override fun getPreferences(): Flow<UserPreferences> {
        return queries.getAllPreferences()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { preferences ->
                val prefMap = preferences.associate { it.preference_key to it.preference_value }
                
                UserPreferences(
                    tensionUnit = prefMap[KEY_TENSION_UNIT]?.let { 
                        TensionUnit.fromAbbreviation(it) 
                    } ?: TensionUnit.KG,
                    
                    ratingScale = prefMap[KEY_RATING_SCALE]?.let { 
                        UserPreferences.RatingScale.valueOf(it) 
                    } ?: UserPreferences.RatingScale.FIVE_STAR,
                    
                    defaultStringType = prefMap[KEY_DEFAULT_STRING_TYPE]?.let { 
                        try { StringType.fromDisplayName(it) } catch (e: Exception) { null }
                    },
                    
                    defaultTension = prefMap[KEY_DEFAULT_TENSION]?.toDoubleOrNull(),
                    
                    autoBackup = prefMap[KEY_AUTO_BACKUP]?.toBoolean() ?: false
                )
            }
    }
    
    override suspend fun updateTensionUnit(unit: TensionUnit) = withContext(Dispatchers.IO) {
        queries.insertOrUpdatePreference(
            preference_key = KEY_TENSION_UNIT,
            preference_value = unit.abbreviation,
            updated_at = Clock.System.now().toEpochMilliseconds()
        )
    }
    
    override suspend fun updateRatingScale(scale: UserPreferences.RatingScale) = withContext(Dispatchers.IO) {
        queries.insertOrUpdatePreference(
            preference_key = KEY_RATING_SCALE,
            preference_value = scale.name,
            updated_at = Clock.System.now().toEpochMilliseconds()
        )
    }
    
    override suspend fun clearAllPreferences() = withContext(Dispatchers.IO) {
        listOf(
            KEY_TENSION_UNIT, KEY_RATING_SCALE, KEY_DEFAULT_STRING_TYPE,
            KEY_DEFAULT_TENSION, KEY_AUTO_BACKUP
        ).forEach { key ->
            queries.deletePreference(key)
        }
    }
}