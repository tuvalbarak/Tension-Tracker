package com.tuv.tensiontracker.domain.usecase.session

import com.tuv.tensiontracker.domain.model.StringingSession
import com.tuv.tensiontracker.domain.repository.StringingSessionRepository
import com.tuv.tensiontracker.domain.repository.StringingLocationRepository

class UpdateStringingSessionUseCase(
    private val sessionRepository: StringingSessionRepository,
    private val locationRepository: StringingLocationRepository
) {
    suspend operator fun invoke(session: StringingSession): Result<Unit> {
        return try {
            // Get original session to check if location changed
            val originalSession = sessionRepository.getSessionById(session.id)
            
            sessionRepository.updateSession(session)
            
            // Update location usage if location changed and is not blank
            val newLocation = session.locationInstalled
            val oldLocation = originalSession?.locationInstalled
            
            if (newLocation != oldLocation && !newLocation.isNullOrBlank()) {
                locationRepository.insertOrIncrementLocation(newLocation)
            }
            
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}