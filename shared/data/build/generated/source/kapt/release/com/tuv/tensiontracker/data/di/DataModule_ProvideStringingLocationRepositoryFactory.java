package com.tuv.tensiontracker.data.di;

import com.tuv.tensiontracker.data.database.TensionTrackerDatabase;
import com.tuv.tensiontracker.domain.repository.StringingLocationRepository;
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
public final class DataModule_ProvideStringingLocationRepositoryFactory implements Factory<StringingLocationRepository> {
  private final Provider<TensionTrackerDatabase> databaseProvider;

  public DataModule_ProvideStringingLocationRepositoryFactory(
      Provider<TensionTrackerDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public StringingLocationRepository get() {
    return provideStringingLocationRepository(databaseProvider.get());
  }

  public static DataModule_ProvideStringingLocationRepositoryFactory create(
      Provider<TensionTrackerDatabase> databaseProvider) {
    return new DataModule_ProvideStringingLocationRepositoryFactory(databaseProvider);
  }

  public static StringingLocationRepository provideStringingLocationRepository(
      TensionTrackerDatabase database) {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideStringingLocationRepository(database));
  }
}
