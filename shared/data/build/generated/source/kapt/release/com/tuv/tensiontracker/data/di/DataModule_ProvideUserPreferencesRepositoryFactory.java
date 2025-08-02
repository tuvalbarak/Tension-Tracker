package com.tuv.tensiontracker.data.di;

import com.tuv.tensiontracker.data.database.TensionTrackerDatabase;
import com.tuv.tensiontracker.domain.repository.UserPreferencesRepository;
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
public final class DataModule_ProvideUserPreferencesRepositoryFactory implements Factory<UserPreferencesRepository> {
  private final Provider<TensionTrackerDatabase> databaseProvider;

  public DataModule_ProvideUserPreferencesRepositoryFactory(
      Provider<TensionTrackerDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public UserPreferencesRepository get() {
    return provideUserPreferencesRepository(databaseProvider.get());
  }

  public static DataModule_ProvideUserPreferencesRepositoryFactory create(
      Provider<TensionTrackerDatabase> databaseProvider) {
    return new DataModule_ProvideUserPreferencesRepositoryFactory(databaseProvider);
  }

  public static UserPreferencesRepository provideUserPreferencesRepository(
      TensionTrackerDatabase database) {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideUserPreferencesRepository(database));
  }
}
