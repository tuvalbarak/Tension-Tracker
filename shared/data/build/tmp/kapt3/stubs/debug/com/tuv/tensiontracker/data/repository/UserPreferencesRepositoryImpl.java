package com.tuv.tensiontracker.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tuv/tensiontracker/data/repository/UserPreferencesRepositoryImpl;", "Lcom/tuv/tensiontracker/domain/repository/UserPreferencesRepository;", "database", "Lcom/tuv/tensiontracker/data/database/TensionTrackerDatabase;", "(Lcom/tuv/tensiontracker/data/database/TensionTrackerDatabase;)V", "queries", "Lcom/tuv/tensiontracker/data/database/UserPreferencesQueries;", "clearAllPreferences", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPreferences", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tuv/tensiontracker/domain/model/UserPreferences;", "savePreferences", "preferences", "(Lcom/tuv/tensiontracker/domain/model/UserPreferences;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRatingScale", "scale", "Lcom/tuv/tensiontracker/domain/model/UserPreferences$RatingScale;", "(Lcom/tuv/tensiontracker/domain/model/UserPreferences$RatingScale;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTensionUnit", "unit", "Lcom/tuv/tensiontracker/domain/model/TensionUnit;", "(Lcom/tuv/tensiontracker/domain/model/TensionUnit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_debug"})
public final class UserPreferencesRepositoryImpl implements com.tuv.tensiontracker.domain.repository.UserPreferencesRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.tuv.tensiontracker.data.database.TensionTrackerDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final com.tuv.tensiontracker.data.database.UserPreferencesQueries queries = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_TENSION_UNIT = "tension_unit";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_RATING_SCALE = "rating_scale";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DEFAULT_STRING_TYPE = "default_string_type";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_DEFAULT_TENSION = "default_tension";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_AUTO_BACKUP = "auto_backup";
    @org.jetbrains.annotations.NotNull()
    public static final com.tuv.tensiontracker.data.repository.UserPreferencesRepositoryImpl.Companion Companion = null;
    
    public UserPreferencesRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.TensionTrackerDatabase database) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object savePreferences(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.domain.model.UserPreferences preferences, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.tuv.tensiontracker.domain.model.UserPreferences> getPreferences() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateTensionUnit(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.domain.model.TensionUnit unit, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateRatingScale(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.domain.model.UserPreferences.RatingScale scale, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object clearAllPreferences(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tuv/tensiontracker/data/repository/UserPreferencesRepositoryImpl$Companion;", "", "()V", "KEY_AUTO_BACKUP", "", "KEY_DEFAULT_STRING_TYPE", "KEY_DEFAULT_TENSION", "KEY_RATING_SCALE", "KEY_TENSION_UNIT", "data_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}