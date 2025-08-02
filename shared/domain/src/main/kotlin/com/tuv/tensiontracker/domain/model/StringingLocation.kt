package com.tuv.tensiontracker.domain.model

import kotlinx.datetime.Instant

data class StringingLocation(
    val id: Long,
    val locationName: String,
    val usageCount: Int,
    val lastUsed: Instant,
    val createdAt: Instant
) {
    companion object {
        fun createNew(locationName: String): StringingLocation {
            val now = kotlinx.datetime.Clock.System.now()
            return StringingLocation(
                id = 0, // Will be set by database
                locationName = locationName,
                usageCount = 1,
                lastUsed = now,
                createdAt = now
            )
        }
    }
}