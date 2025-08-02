package com.tuv.tensiontracker.domain.repository

import com.tuv.tensiontracker.domain.model.SessionFeedback
import kotlinx.coroutines.flow.Flow

interface SessionFeedbackRepository {
    
    suspend fun insertFeedback(feedback: SessionFeedback): Long
    
    suspend fun updateFeedback(feedback: SessionFeedback)
    
    suspend fun deleteFeedbackBySessionId(sessionId: Long)
    
    suspend fun getFeedbackBySessionId(sessionId: Long): SessionFeedback?
    
    fun getAllFeedback(): Flow<List<SessionFeedback>>
    
    suspend fun getFeedbackWithHighRatings(minRating: Int): List<SessionFeedback>
}