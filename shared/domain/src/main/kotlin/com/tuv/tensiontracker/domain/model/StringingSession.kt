package com.tuv.tensiontracker.domain.model

import kotlinx.datetime.Instant

data class StringingSession(
    val id: Long,
    val dateStrung: Instant,
    val mainStringId: Long,
    val crossStringId: Long?, // For hybrid setups
    val mainTension: Tension,
    val crossTension: Tension?,
    val pricePaid: Double?,
    val locationInstalled: String?,
    val hoursUntilBreak: Double?,
    val hoursUntilDead: Double?,
    val createdAt: Instant,
    val updatedAt: Instant
) {
    companion object {
        fun createNew(
            mainStringId: Long,
            mainTension: Tension,
            crossStringId: Long? = null,
            crossTension: Tension? = null
        ): StringingSession {
            val now = kotlinx.datetime.Clock.System.now()
            return StringingSession(
                id = 0, // Will be set by database
                dateStrung = now,
                mainStringId = mainStringId,
                crossStringId = crossStringId,
                mainTension = mainTension,
                crossTension = crossTension,
                pricePaid = null,
                locationInstalled = null,
                hoursUntilBreak = null,
                hoursUntilDead = null,
                createdAt = now,
                updatedAt = now
            )
        }
    }
    
    val isHybrid: Boolean
        get() = crossStringId != null
        
    val daysSinceStringing: Long
        get() {
            val now = kotlinx.datetime.Clock.System.now()
            return (now - dateStrung).inWholeDays
        }
        
    val hoursActiveTotal: Double?
        get() = hoursUntilBreak ?: hoursUntilDead
}