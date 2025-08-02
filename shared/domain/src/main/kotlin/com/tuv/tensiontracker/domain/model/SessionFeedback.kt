package com.tuv.tensiontracker.domain.model

import kotlinx.datetime.Instant

data class SessionFeedback(
    val id: Long,
    val sessionId: Long,
    val controlRating: Int?, // 1-5 or 1-100 depending on preference
    val powerRating: Int?,
    val durabilityRating: Int?,
    val spinRating: Int?,
    val feelRating: Int?,
    val comfortRating: Int?,
    val notes: String?,
    val createdAt: Instant,
    val updatedAt: Instant
) {
    companion object {
        fun createNew(sessionId: Long): SessionFeedback {
            val now = kotlinx.datetime.Clock.System.now()
            return SessionFeedback(
                id = 0, // Will be set by database
                sessionId = sessionId,
                controlRating = null,
                powerRating = null,
                durabilityRating = null,
                spinRating = null,
                feelRating = null,
                comfortRating = null,
                notes = null,
                createdAt = now,
                updatedAt = now
            )
        }
    }
    
    val hasAnyRating: Boolean
        get() = listOf(controlRating, powerRating, durabilityRating, spinRating, feelRating, comfortRating)
            .any { it != null }
    
    val averageRating: Double?
        get() {
            val ratings = listOf(controlRating, powerRating, durabilityRating, spinRating, feelRating, comfortRating)
                .filterNotNull()
            return if (ratings.isNotEmpty()) ratings.average() else null
        }
}