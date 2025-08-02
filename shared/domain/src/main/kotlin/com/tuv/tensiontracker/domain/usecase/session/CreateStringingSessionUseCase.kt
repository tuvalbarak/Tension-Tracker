package com.tuv.tensiontracker.domain.usecase.session

import com.tuv.tensiontracker.domain.model.StringingSession
import com.tuv.tensiontracker.domain.repository.StringingSessionRepository
import com.tuv.tensiontracker.domain.repository.StringingLocationRepository
import javax.inject.Inject

class CreateStringingSessionUseCase @Inject constructor(
    private val sessionRepository: StringingSessionRepository,
    private val locationRepository: StringingLocationRepository
) {
    suspend operator fun invoke(session: StringingSession): Result<Long> {
        return try {
            val sessionId = sessionRepository.insertSession(session)
            
            // Update location usage if provided
            session.locationInstalled?.let { location ->
                if (location.isNotBlank()) {
                    locationRepository.insertOrIncrementLocation(location)
                }
            }
            
            Result.success(sessionId)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}