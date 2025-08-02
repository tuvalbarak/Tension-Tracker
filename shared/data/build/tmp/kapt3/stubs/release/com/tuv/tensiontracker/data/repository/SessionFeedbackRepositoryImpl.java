package com.tuv.tensiontracker.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rH\u0016J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000fH\u0096@\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tuv/tensiontracker/data/repository/SessionFeedbackRepositoryImpl;", "Lcom/tuv/tensiontracker/domain/repository/SessionFeedbackRepository;", "database", "Lcom/tuv/tensiontracker/data/database/TensionTrackerDatabase;", "(Lcom/tuv/tensiontracker/data/database/TensionTrackerDatabase;)V", "queries", "Lcom/tuv/tensiontracker/data/database/SessionFeedbackQueries;", "deleteFeedbackBySessionId", "", "sessionId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFeedback", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/tuv/tensiontracker/domain/model/SessionFeedback;", "getFeedbackBySessionId", "getFeedbackWithHighRatings", "minRating", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFeedback", "feedback", "(Lcom/tuv/tensiontracker/domain/model/SessionFeedback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFeedback", "data_release"})
public final class SessionFeedbackRepositoryImpl implements com.tuv.tensiontracker.domain.repository.SessionFeedbackRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.tuv.tensiontracker.data.database.TensionTrackerDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.tuv.tensiontracker.data.database.SessionFeedbackQueries queries = null;
    
    public SessionFeedbackRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.TensionTrackerDatabase database) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertFeedback(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.domain.model.SessionFeedback feedback, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateFeedback(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.domain.model.SessionFeedback feedback, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteFeedbackBySessionId(long sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getFeedbackBySessionId(long sessionId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.tuv.tensiontracker.domain.model.SessionFeedback> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.tuv.tensiontracker.domain.model.SessionFeedback>> getAllFeedback() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getFeedbackWithHighRatings(int minRating, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.tuv.tensiontracker.domain.model.SessionFeedback>> $completion) {
        return null;
    }
}