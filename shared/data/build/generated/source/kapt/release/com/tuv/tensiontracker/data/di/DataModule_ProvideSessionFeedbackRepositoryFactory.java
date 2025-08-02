package com.tuv.tensiontracker.data.di;

import com.tuv.tensiontracker.data.database.TensionTrackerDatabase;
import com.tuv.tensiontracker.domain.repository.SessionFeedbackRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class DataModule_ProvideSessionFeedbackRepositoryFactory implements Factory<SessionFeedbackRepository> {
  private final Provider<TensionTrackerDatabase> databaseProvider;

  public DataModule_ProvideSessionFeedbackRepositoryFactory(
      Provider<TensionTrackerDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public SessionFeedbackRepository get() {
    return provideSessionFeedbackRepository(databaseProvider.get());
  }

  public static DataModule_ProvideSessionFeedbackRepositoryFactory create(
      Provider<TensionTrackerDatabase> databaseProvider) {
    return new DataModule_ProvideSessionFeedbackRepositoryFactory(databaseProvider);
  }

  public static SessionFeedbackRepository provideSessionFeedbackRepository(
      TensionTrackerDatabase database) {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideSessionFeedbackRepository(database));
  }
}
