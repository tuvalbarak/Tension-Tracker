package com.tuv.tensiontracker.data.di;

import com.tuv.tensiontracker.data.database.TensionTrackerDatabase;
import com.tuv.tensiontracker.domain.repository.StringingSessionRepository;
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
public final class DataModule_ProvideStringingSessionRepositoryFactory implements Factory<StringingSessionRepository> {
  private final Provider<TensionTrackerDatabase> databaseProvider;

  public DataModule_ProvideStringingSessionRepositoryFactory(
      Provider<TensionTrackerDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public StringingSessionRepository get() {
    return provideStringingSessionRepository(databaseProvider.get());
  }

  public static DataModule_ProvideStringingSessionRepositoryFactory create(
      Provider<TensionTrackerDatabase> databaseProvider) {
    return new DataModule_ProvideStringingSessionRepositoryFactory(databaseProvider);
  }

  public static StringingSessionRepository provideStringingSessionRepository(
      TensionTrackerDatabase database) {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideStringingSessionRepository(database));
  }
}
