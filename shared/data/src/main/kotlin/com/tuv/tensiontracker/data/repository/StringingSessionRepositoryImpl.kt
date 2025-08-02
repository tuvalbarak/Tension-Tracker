package com.tuv.tensiontracker.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.tuv.tensiontracker.data.database.TensionTrackerDatabase
import com.tuv.tensiontracker.data.mapper.DomainMapper
import com.tuv.tensiontracker.domain.model.SessionWithDetails
import com.tuv.tensiontracker.domain.model.StringingSession
import com.tuv.tensiontracker.domain.repository.StringingSessionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock

class StringingSessionRepositoryImpl(
    private val database: TensionTrackerDatabase
) : StringingSessionRepository {
    
    private val queries = database.stringingSessionsQueries
    private val stringQueries = database.stringCatalogQueries
    private val feedbackQueries = database.sessionFeedbackQueries
    
    override suspend fun insertSession(session: StringingSession): Long = withContext(Dispatchers.IO) {
        val now = Clock.System.now()
        queries.insertSession(
            date_strung = session.dateStrung.toEpochMilliseconds(),
            main_string_id = session.mainStringId,
            cross_string_id = session.crossStringId,
            main_tension_value = session.mainTension.value,
            main_tension_unit = session.mainTension.unit.abbreviation,
            cross_tension_value = session.crossTension?.value,
            cross_tension_unit = session.crossTension?.unit?.abbreviation,
            price_paid = session.pricePaid,
            location_installed = session.locationInstalled,
            hours_until_break = session.hoursUntilBreak,
            hours_until_dead = session.hoursUntilDead,
            created_at = now.toEpochMilliseconds(),
            updated_at = now.toEpochMilliseconds()
        )
        queries.getLastInsertedSessionId().executeAsOne()
    }
    
    override suspend fun updateSession(session: StringingSession) = withContext(Dispatchers.IO) {
        val now = Clock.System.now()
        queries.updateSession(
            date_strung = session.dateStrung.toEpochMilliseconds(),
            main_string_id = session.mainStringId,
            cross_string_id = session.crossStringId,
            main_tension_value = session.mainTension.value,
            main_tension_unit = session.mainTension.unit.abbreviation,
            cross_tension_value = session.crossTension?.value,
            cross_tension_unit = session.crossTension?.unit?.abbreviation,
            price_paid = session.pricePaid,
            location_installed = session.locationInstalled,
            hours_until_break = session.hoursUntilBreak,
            hours_until_dead = session.hoursUntilDead,
            updated_at = now.toEpochMilliseconds(),
            id = session.id
        )
    }
    
    override suspend fun deleteSession(sessionId: Long) = withContext(Dispatchers.IO) {
        queries.deleteSession(sessionId)
    }
    
    override suspend fun getSessionById(sessionId: Long): StringingSession? = withContext(Dispatchers.IO) {
        queries.getSessionById(sessionId).executeAsOneOrNull()?.let { 
            DomainMapper.mapStringSession(it) 
        }
    }
    
    override fun getAllSessions(): Flow<List<StringingSession>> {
        return queries.getAllSessions()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { dbSessions ->
                dbSessions.map { DomainMapper.mapStringSession(it) }
            }
    }
    
    override fun getAllSessionsWithDetails(): Flow<List<SessionWithDetails>> {
        val sessionsFlow = getAllSessions()
        val stringsFlow = stringQueries.getAllActiveStrings().asFlow().mapToList(Dispatchers.IO)
        val feedbackFlow = feedbackQueries.getAllFeedbackWithSessions().asFlow().mapToList(Dispatchers.IO)
        
        return combine(sessionsFlow, stringsFlow, feedbackFlow) { sessions, strings, feedbacks ->
            sessions.map { session ->
                val mainString = strings.find { it.id == session.mainStringId }
                    ?.let { DomainMapper.mapStringModel(it) }
                
                val crossString = session.crossStringId?.let { crossId ->
                    strings.find { it.id == crossId }?.let { DomainMapper.mapStringModel(it) }
                }
                
                val feedback = feedbacks.find { it.session_id == session.id }
                    ?.let { DomainMapper.mapSessionFeedbackFromJoin(it) }
                
                SessionWithDetails(
                    session = session,
                    mainString = mainString ?: createFallbackString(session.mainStringId),
                    crossString = crossString,
                    feedback = feedback
                )
            }
        }
    }
    
    override suspend fun getSessionsByStringId(stringId: Long): List<StringingSession> = withContext(Dispatchers.IO) {
        queries.getSessionsByString(stringId, stringId).executeAsList()
            .map { DomainMapper.mapStringSession(it) }
    }
    
    override suspend fun getSessionsByLocation(location: String): List<StringingSession> = withContext(Dispatchers.IO) {
        queries.getSessionsByLocation(location).executeAsList()
            .map { DomainMapper.mapStringSession(it) }
    }
    
    override suspend fun searchSessions(query: String): List<SessionWithDetails> = withContext(Dispatchers.IO) {
        // For now, search by location. Could be expanded to search by string name, etc.
        val sessions = queries.getSessionsByLocation(query).executeAsList()
            .map { DomainMapper.mapStringSession(it) }
        
        val strings = stringQueries.getAllActiveStrings().executeAsList()
        val feedbacks = feedbackQueries.getAllFeedbackWithSessions().executeAsList()
        
        sessions.map { session ->
            val mainString = strings.find { it.id == session.mainStringId }
                ?.let { DomainMapper.mapStringModel(it) }
            
            val crossString = session.crossStringId?.let { crossId ->
                strings.find { it.id == crossId }?.let { DomainMapper.mapStringModel(it) }
            }
            
            val feedback = feedbacks.find { it.session_id == session.id }
                ?.let { DomainMapper.mapSessionFeedbackFromJoin(it) }
            
            SessionWithDetails(
                session = session,
                mainString = mainString ?: createFallbackString(session.mainStringId),
                crossString = crossString,
                feedback = feedback
            )
        }
    }
    
    private fun createFallbackString(stringId: Long) = com.tuv.tensiontracker.domain.model.StringModel(
        id = stringId,
        name = "Unknown String",
        brand = "Unknown",
        type = com.tuv.tensiontracker.domain.model.StringType.POLY,
        gaugeMm = null,
        construction = null,
        notes = null,
        priceMin = null,
        priceMax = null,
        isActive = false
    )
}