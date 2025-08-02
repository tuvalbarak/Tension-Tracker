package com.tuv.tensiontracker.domain.usecase.session

import com.tuv.tensiontracker.domain.model.SessionWithDetails
import com.tuv.tensiontracker.domain.repository.StringingSessionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSessionsWithDetailsUseCase @Inject constructor(
    private val sessionRepository: StringingSessionRepository
) {
    operator fun invoke(): Flow<List<SessionWithDetails>> {
        return sessionRepository.getAllSessionsWithDetails()
    }
}