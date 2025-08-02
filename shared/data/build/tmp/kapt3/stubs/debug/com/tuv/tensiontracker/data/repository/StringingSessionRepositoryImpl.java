package com.tuv.tensiontracker.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014H\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00150\u0014H\u0016J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@\u00a2\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0016H\u0096@\u00a2\u0006\u0002\u0010!J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00180\u00152\u0006\u0010#\u001a\u00020\u001cH\u0096@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010$\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0016H\u0096@\u00a2\u0006\u0002\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tuv/tensiontracker/data/repository/StringingSessionRepositoryImpl;", "Lcom/tuv/tensiontracker/domain/repository/StringingSessionRepository;", "database", "Lcom/tuv/tensiontracker/data/database/TensionTrackerDatabase;", "(Lcom/tuv/tensiontracker/data/database/TensionTrackerDatabase;)V", "feedbackQueries", "Lcom/tuv/tensiontracker/data/database/SessionFeedbackQueries;", "queries", "Lcom/tuv/tensiontracker/data/database/StringingSessionsQueries;", "stringQueries", "Lcom/tuv/tensiontracker/data/database/StringCatalogQueries;", "createFallbackString", "Lcom/tuv/tensiontracker/domain/model/StringModel;", "stringId", "", "deleteSession", "", "sessionId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSessions", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/tuv/tensiontracker/domain/model/StringingSession;", "getAllSessionsWithDetails", "Lcom/tuv/tensiontracker/domain/model/SessionWithDetails;", "getSessionById", "getSessionsByLocation", "location", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSessionsByStringId", "insertSession", "session", "(Lcom/tuv/tensiontracker/domain/model/StringingSession;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchSessions", "query", "updateSession", "data_debug"})
public final class StringingSessionRepositoryImpl implements com.tuv.tensiontracker.domain.repository.StringingSessionRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.tuv.tensiontracker.data.database.TensionTrackerDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.tuv.tensiontracker.data.database.StringingSessionsQueries queries = null;
    @org.jetbrains.annotations.NotNull()
    private final com.tuv.tensiontracker.data.database.StringCatalogQueries stringQueries = null;
    @org.jetbrains.annotations.NotNull()
    private final com.tuv.tensiontracker.data.database.SessionFeedbackQueries feedbackQueries = null;
    
    public StringingSessionRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.TensionTrackerDatabase database) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertSession(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.domain.model.StringingSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateSession(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.domain.model.StringingSession session, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteSession(long sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getSessionById(long sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.tuv.tensiontracker.domain.model.StringingSession> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.tuv.tensiontracker.domain.model.StringingSession>> getAllSessions() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.tuv.tensiontracker.domain.model.SessionWithDetails>> getAllSessionsWithDetails() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getSessionsByStringId(long stringId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.tuv.tensiontracker.domain.model.StringingSession>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getSessionsByLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String location, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.tuv.tensiontracker.domain.model.StringingSession>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object searchSessions(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.tuv.tensiontracker.domain.model.SessionWithDetails>> $completion) {
        return null;
    }
    
    private final com.tuv.tensiontracker.domain.model.StringModel createFallbackString(long stringId) {
        return null;
    }
}