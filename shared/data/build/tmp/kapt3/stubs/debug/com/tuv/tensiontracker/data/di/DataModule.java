package com.tuv.tensiontracker.data.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u0004H\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/tuv/tensiontracker/data/di/DataModule;", "", "()V", "provideDatabase", "Lcom/tuv/tensiontracker/data/database/TensionTrackerDatabase;", "databaseFactory", "Lcom/tuv/tensiontracker/data/database/DatabaseFactory;", "provideDatabaseFactory", "context", "Landroid/content/Context;", "provideSessionFeedbackRepository", "Lcom/tuv/tensiontracker/domain/repository/SessionFeedbackRepository;", "database", "provideStringCatalogRepository", "Lcom/tuv/tensiontracker/domain/repository/StringCatalogRepository;", "provideStringingLocationRepository", "Lcom/tuv/tensiontracker/domain/repository/StringingLocationRepository;", "provideStringingSessionRepository", "Lcom/tuv/tensiontracker/domain/repository/StringingSessionRepository;", "provideUserPreferencesRepository", "Lcom/tuv/tensiontracker/domain/repository/UserPreferencesRepository;", "data_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DataModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.tuv.tensiontracker.data.di.DataModule INSTANCE = null;
    
    private DataModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.tuv.tensiontracker.data.database.DatabaseFactory provideDatabaseFactory(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.tuv.tensiontracker.data.database.TensionTrackerDatabase provideDatabase(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.DatabaseFactory databaseFactory) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.tuv.tensiontracker.domain.repository.StringCatalogRepository provideStringCatalogRepository(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.TensionTrackerDatabase database, @dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.tuv.tensiontracker.domain.repository.StringingSessionRepository provideStringingSessionRepository(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.TensionTrackerDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.tuv.tensiontracker.domain.repository.SessionFeedbackRepository provideSessionFeedbackRepository(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.TensionTrackerDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.tuv.tensiontracker.domain.repository.UserPreferencesRepository provideUserPreferencesRepository(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.TensionTrackerDatabase database) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.tuv.tensiontracker.domain.repository.StringingLocationRepository provideStringingLocationRepository(@org.jetbrains.annotations.NotNull()
    com.tuv.tensiontracker.data.database.TensionTrackerDatabase database) {
        return null;
    }
}