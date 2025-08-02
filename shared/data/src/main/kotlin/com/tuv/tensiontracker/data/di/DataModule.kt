package com.tuv.tensiontracker.data.di

import android.content.Context
import com.tuv.tensiontracker.data.database.DatabaseFactory
import com.tuv.tensiontracker.data.database.TensionTrackerDatabase
import com.tuv.tensiontracker.data.repository.SessionFeedbackRepositoryImpl
import com.tuv.tensiontracker.data.repository.StringCatalogRepositoryImpl
import com.tuv.tensiontracker.data.repository.StringingLocationRepositoryImpl
import com.tuv.tensiontracker.data.repository.StringingSessionRepositoryImpl
import com.tuv.tensiontracker.data.repository.UserPreferencesRepositoryImpl
import com.tuv.tensiontracker.domain.repository.SessionFeedbackRepository
import com.tuv.tensiontracker.domain.repository.StringCatalogRepository
import com.tuv.tensiontracker.domain.repository.StringingLocationRepository
import com.tuv.tensiontracker.domain.repository.StringingSessionRepository
import com.tuv.tensiontracker.domain.repository.UserPreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    
    @Provides
    @Singleton
    fun provideDatabaseFactory(@ApplicationContext context: Context): DatabaseFactory {
        return DatabaseFactory(context)
    }
    
    @Provides
    @Singleton
    fun provideDatabase(databaseFactory: DatabaseFactory): TensionTrackerDatabase {
        return databaseFactory.createDatabase()
    }
    
    @Provides
    @Singleton
    fun provideStringCatalogRepository(
        database: TensionTrackerDatabase,
        @ApplicationContext context: Context
    ): StringCatalogRepository {
        return StringCatalogRepositoryImpl(database, context)
    }
    
    @Provides
    @Singleton
    fun provideStringingSessionRepository(
        database: TensionTrackerDatabase
    ): StringingSessionRepository {
        return StringingSessionRepositoryImpl(database)
    }
    
    @Provides
    @Singleton
    fun provideSessionFeedbackRepository(
        database: TensionTrackerDatabase
    ): SessionFeedbackRepository {
        return SessionFeedbackRepositoryImpl(database)
    }
    
    @Provides
    @Singleton
    fun provideUserPreferencesRepository(
        database: TensionTrackerDatabase
    ): UserPreferencesRepository {
        return UserPreferencesRepositoryImpl(database)
    }
    
    @Provides
    @Singleton
    fun provideStringingLocationRepository(
        database: TensionTrackerDatabase
    ): StringingLocationRepository {
        return StringingLocationRepositoryImpl(database)
    }
}