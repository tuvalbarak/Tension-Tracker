package com.tuv.tensiontracker.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.tuv.tensiontracker.data.database.TensionTrackerDatabase
import com.tuv.tensiontracker.data.mapper.DomainMapper
import com.tuv.tensiontracker.domain.model.SessionFeedback
import com.tuv.tensiontracker.domain.repository.SessionFeedbackRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock

class SessionFeedbackRepositoryImpl(
    private val database: TensionTrackerDatabase
) : SessionFeedbackRepository {
    
    private val queries = database.sessionFeedbackQueries
    
    override suspend fun insertFeedback(feedback: SessionFeedback): Long = withContext(Dispatchers.IO) {
        val now = Clock.System.now()
        queries.insertFeedback(
            session_id = feedback.sessionId,
            control_rating = feedback.controlRating?.toLong(),
            power_rating = feedback.powerRating?.toLong(),
            durability_rating = feedback.durabilityRating?.toLong(),
            spin_rating = feedback.spinRating?.toLong(),
            feel_rating = feedback.feelRating?.toLong(),
            comfort_rating = feedback.comfortRating?.toLong(),
            notes = feedback.notes,
            created_at = now.toEpochMilliseconds(),
            updated_at = now.toEpochMilliseconds()
        )
        feedback.id
    }
    
    override suspend fun updateFeedback(feedback: SessionFeedback) = withContext(Dispatchers.IO) {
        val now = Clock.System.now()
        queries.updateFeedback(
            control_rating = feedback.controlRating?.toLong(),
            power_rating = feedback.powerRating?.toLong(),
            durability_rating = feedback.durabilityRating?.toLong(),
            spin_rating = feedback.spinRating?.toLong(),
            feel_rating = feedback.feelRating?.toLong(),
            comfort_rating = feedback.comfortRating?.toLong(),
            notes = feedback.notes,
            updated_at = now.toEpochMilliseconds(),
            session_id = feedback.sessionId
        )
    }
    
    override suspend fun deleteFeedbackBySessionId(sessionId: Long) = withContext(Dispatchers.IO) {
        queries.deleteFeedbackBySessionId(sessionId)
    }
    
    override suspend fun getFeedbackBySessionId(sessionId: Long): SessionFeedback? = withContext(Dispatchers.IO) {
        queries.getFeedbackBySessionId(sessionId).executeAsOneOrNull()?.let { 
            DomainMapper.mapSessionFeedback(it) 
        }
    }
    
    override fun getAllFeedback(): Flow<List<SessionFeedback>> {
        return queries.getAllFeedbackWithSessions()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { dbFeedbacks ->
                dbFeedbacks.map { DomainMapper.mapSessionFeedbackFromJoin(it) }
            }
    }
    
    override suspend fun getFeedbackWithHighRatings(minRating: Int): List<SessionFeedback> = withContext(Dispatchers.IO) {
        // This is a simplified implementation - in a real app you might want more complex filtering
        queries.getAllFeedbackWithSessions().executeAsList()
            .map { DomainMapper.mapSessionFeedbackFromJoin(it) }
            .filter { feedback ->
                listOf(
                    feedback.controlRating, feedback.powerRating, feedback.durabilityRating,
                    feedback.spinRating, feedback.feelRating, feedback.comfortRating
                ).filterNotNull().any { it >= minRating }
            }
    }
}