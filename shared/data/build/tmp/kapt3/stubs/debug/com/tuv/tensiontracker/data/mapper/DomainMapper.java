package com.tuv.tensiontracker.data.mapper;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tuv/tensiontracker/data/mapper/DomainMapper;", "", "()V", "mapSessionFeedback", "Lcom/tuv/tensiontracker/domain/model/SessionFeedback;", "dbFeedback", "Lcom/tuv/tensiontracker/data/database/Session_feedback;", "mapSessionFeedbackFromJoin", "Lcom/tuv/tensiontracker/data/database/GetAllFeedbackWithSessions;", "mapStringLocation", "Lcom/tuv/tensiontracker/domain/model/StringingLocation;", "dbLocation", "Lcom/tuv/tensiontracker/data/database/Stringing_locations;", "mapStringModel", "Lcom/tuv/tensiontracker/domain/model/StringModel;", "dbString", "Lcom/tuv/tensiontracker/data/database/String_catalog;", "mapStringSession", "Lcom/tuv/tensiontracker/domain/model/StringingSession;", "dbSession", "Lcom/tuv/tensiontracker/data/database/Stringing_sessions;", "data_debug"})
public final class DomainMapper {
    @org.jetbrains.annotations.NotNull()
    public static final com.tuv.tensiontracker.data.mapper.DomainMapper INSTANCE = null;
    
    private DomainMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.tuv.tensiontracker.domain.model.StringingSession mapStringSession(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.Stringing_sessions dbSession) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.tuv.tensiontracker.domain.model.SessionFeedback mapSessionFeedback(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.Session_feedback dbFeedback) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.tuv.tensiontracker.domain.model.SessionFeedback mapSessionFeedbackFromJoin(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.GetAllFeedbackWithSessions dbFeedback) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.tuv.tensiontracker.domain.model.StringModel mapStringModel(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.String_catalog dbString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.tuv.tensiontracker.domain.model.StringingLocation mapStringLocation(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.Stringing_locations dbLocation) {
        return null;
    }
}