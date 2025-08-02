package com.tuv.tensiontracker.domain.repository

import com.tuv.tensiontracker.domain.model.SessionWithDetails
import com.tuv.tensiontracker.domain.model.StringingSession
import kotlinx.coroutines.flow.Flow

interface StringingSessionRepository {
    
    suspend fun insertSession(session: StringingSession): Long
    
    suspend fun updateSession(session: StringingSession)
    
    suspend fun deleteSession(sessionId: Long)
    
    suspend fun getSessionById(sessionId: Long): StringingSession?
    
    fun getAllSessions(): Flow<List<StringingSession>>
    
    fun getAllSessionsWithDetails(): Flow<List<SessionWithDetails>>
    
    suspend fun getSessionsByStringId(stringId: Long): List<StringingSession>
    
    suspend fun getSessionsByLocation(location: String): List<StringingSession>
    
    suspend fun searchSessions(query: String): List<SessionWithDetails>
}