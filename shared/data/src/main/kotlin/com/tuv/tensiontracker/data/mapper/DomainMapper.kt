package com.tuv.tensiontracker.data.mapper

import com.tuv.tensiontracker.data.database.GetAllFeedbackWithSessions
import com.tuv.tensiontracker.data.database.Session_feedback
import com.tuv.tensiontracker.data.database.String_catalog
import com.tuv.tensiontracker.data.database.Stringing_locations
import com.tuv.tensiontracker.data.database.Stringing_sessions
import com.tuv.tensiontracker.domain.model.SessionFeedback
import com.tuv.tensiontracker.domain.model.StringModel
import com.tuv.tensiontracker.domain.model.StringType
import com.tuv.tensiontracker.domain.model.StringingLocation
import com.tuv.tensiontracker.domain.model.StringingSession
import com.tuv.tensiontracker.domain.model.Tension
import com.tuv.tensiontracker.domain.model.TensionUnit
import kotlinx.datetime.Instant

object DomainMapper {
    
    fun mapStringSession(dbSession: Stringing_sessions): StringingSession {
        return StringingSession(
            id = dbSession.id,
            dateStrung = Instant.fromEpochMilliseconds(dbSession.date_strung),
            mainStringId = dbSession.main_string_id,
            crossStringId = dbSession.cross_string_id,
            mainTension = Tension(
                dbSession.main_tension_value, 
                TensionUnit.fromAbbreviation(dbSession.main_tension_unit)
            ),
            crossTension = if (dbSession.cross_tension_value != null && dbSession.cross_tension_unit != null) {
                Tension(
                    dbSession.cross_tension_value, 
                    TensionUnit.fromAbbreviation(dbSession.cross_tension_unit)
                )
            } else null,
            pricePaid = dbSession.price_paid,
            locationInstalled = dbSession.location_installed,
            hoursUntilBreak = dbSession.hours_until_break,
            hoursUntilDead = dbSession.hours_until_dead,
            createdAt = Instant.fromEpochMilliseconds(dbSession.created_at),
            updatedAt = Instant.fromEpochMilliseconds(dbSession.updated_at)
        )
    }
    
    fun mapSessionFeedback(dbFeedback: Session_feedback): SessionFeedback {
        return SessionFeedback(
            id = dbFeedback.id,
            sessionId = dbFeedback.session_id,
            controlRating = dbFeedback.control_rating?.toInt(),
            powerRating = dbFeedback.power_rating?.toInt(),
            durabilityRating = dbFeedback.durability_rating?.toInt(),
            spinRating = dbFeedback.spin_rating?.toInt(),
            feelRating = dbFeedback.feel_rating?.toInt(),
            comfortRating = dbFeedback.comfort_rating?.toInt(),
            notes = dbFeedback.notes,
            createdAt = Instant.fromEpochMilliseconds(dbFeedback.created_at),
            updatedAt = Instant.fromEpochMilliseconds(dbFeedback.updated_at)
        )
    }
    
    fun mapSessionFeedbackFromJoin(dbFeedback: GetAllFeedbackWithSessions): SessionFeedback {
        return SessionFeedback(
            id = dbFeedback.id,
            sessionId = dbFeedback.session_id,
            controlRating = dbFeedback.control_rating?.toInt(),
            powerRating = dbFeedback.power_rating?.toInt(),
            durabilityRating = dbFeedback.durability_rating?.toInt(),
            spinRating = dbFeedback.spin_rating?.toInt(),
            feelRating = dbFeedback.feel_rating?.toInt(),
            comfortRating = dbFeedback.comfort_rating?.toInt(),
            notes = dbFeedback.notes,
            createdAt = Instant.fromEpochMilliseconds(dbFeedback.created_at),
            updatedAt = Instant.fromEpochMilliseconds(dbFeedback.updated_at)
        )
    }
    
    fun mapStringModel(dbString: String_catalog): StringModel {
        return StringModel(
            id = dbString.id,
            name = dbString.name,
            brand = dbString.brand,
            type = StringType.fromDisplayName(dbString.type),
            gaugeMm = dbString.gauge_mm,
            construction = dbString.construction,
            notes = dbString.notes,
            priceMin = dbString.price_min,
            priceMax = dbString.price_max,
            isActive = dbString.is_active == 1L
        )
    }
    
    fun mapStringLocation(dbLocation: Stringing_locations): StringingLocation {
        return StringingLocation(
            id = dbLocation.id,
            locationName = dbLocation.location_name,
            usageCount = dbLocation.usage_count.toInt(),
            lastUsed = Instant.fromEpochMilliseconds(dbLocation.last_used),
            createdAt = Instant.fromEpochMilliseconds(dbLocation.created_at)
        )
    }
}