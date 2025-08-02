package com.tuv.tensiontracker.domain.di

import com.tuv.tensiontracker.domain.repository.SessionFeedbackRepository
import com.tuv.tensiontracker.domain.repository.StringCatalogRepository
import com.tuv.tensiontracker.domain.repository.StringingLocationRepository
import com.tuv.tensiontracker.domain.repository.StringingSessionRepository
import com.tuv.tensiontracker.domain.usecase.feedback.SaveSessionFeedbackUseCase
import com.tuv.tensiontracker.domain.usecase.recommendations.GetStringRecommendationsUseCase
import com.tuv.tensiontracker.domain.usecase.session.CreateStringingSessionUseCase
import com.tuv.tensiontracker.domain.usecase.session.GetSessionsWithDetailsUseCase
import com.tuv.tensiontracker.domain.usecase.session.UpdateStringingSessionUseCase
import com.tuv.tensiontracker.domain.usecase.strings.GetStringCatalogUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    
    @Provides
    @Singleton
    fun provideCreateStringingSessionUseCase(
        sessionRepository: StringingSessionRepository,
        locationRepository: StringingLocationRepository
    ): CreateStringingSessionUseCase {
        return CreateStringingSessionUseCase(sessionRepository, locationRepository)
    }
    
    @Provides
    @Singleton
    fun provideUpdateStringingSessionUseCase(
        sessionRepository: StringingSessionRepository,
        locationRepository: StringingLocationRepository
    ): UpdateStringingSessionUseCase {
        return UpdateStringingSessionUseCase(sessionRepository, locationRepository)
    }
    
    @Provides
    @Singleton
    fun provideGetSessionsWithDetailsUseCase(
        sessionRepository: StringingSessionRepository
    ): GetSessionsWithDetailsUseCase {
        return GetSessionsWithDetailsUseCase(sessionRepository)
    }
    
    @Provides
    @Singleton
    fun provideSaveSessionFeedbackUseCase(
        feedbackRepository: SessionFeedbackRepository
    ): SaveSessionFeedbackUseCase {
        return SaveSessionFeedbackUseCase(feedbackRepository)
    }
    
    @Provides
    @Singleton
    fun provideGetStringCatalogUseCase(
        stringCatalogRepository: StringCatalogRepository
    ): GetStringCatalogUseCase {
        return GetStringCatalogUseCase(stringCatalogRepository)
    }
    
    @Provides
    @Singleton
    fun provideGetStringRecommendationsUseCase(
        stringCatalogRepository: StringCatalogRepository
    ): GetStringRecommendationsUseCase {
        return GetStringRecommendationsUseCase(stringCatalogRepository)
    }
}