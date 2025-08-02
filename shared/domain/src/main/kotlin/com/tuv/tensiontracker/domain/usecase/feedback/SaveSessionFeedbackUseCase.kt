package com.tuv.tensiontracker.domain.usecase.feedback

import com.tuv.tensiontracker.domain.model.SessionFeedback
import com.tuv.tensiontracker.domain.repository.SessionFeedbackRepository

class SaveSessionFeedbackUseCase(
    private val feedbackRepository: SessionFeedbackRepository
) {
    suspend operator fun invoke(feedback: SessionFeedback): Result<Unit> {
        return try {
            // Check if feedback already exists for this session
            val existingFeedback = feedbackRepository.getFeedbackBySessionId(feedback.sessionId)
            
            if (existingFeedback != null) {
                // Update existing feedback
                feedbackRepository.updateFeedback(feedback.copy(id = existingFeedback.id))
            } else {
                // Create new feedback
                feedbackRepository.insertFeedback(feedback)
            }
            
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}