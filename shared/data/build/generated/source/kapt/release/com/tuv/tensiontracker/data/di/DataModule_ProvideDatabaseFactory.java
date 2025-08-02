package com.tuv.tensiontracker.data.di;

import com.tuv.tensiontracker.data.database.DatabaseFactory;
import com.tuv.tensiontracker.data.database.TensionTrackerDatabase;
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
public final class DataModule_ProvideDatabaseFactory implements Factory<TensionTrackerDatabase> {
  private final Provider<DatabaseFactory> databaseFactoryProvider;

  public DataModule_ProvideDatabaseFactory(Provider<DatabaseFactory> databaseFactoryProvider) {
    this.databaseFactoryProvider = databaseFactoryProvider;
  }

  @Override
  public TensionTrackerDatabase get() {
    return provideDatabase(databaseFactoryProvider.get());
  }

  public static DataModule_ProvideDatabaseFactory create(
      Provider<DatabaseFactory> databaseFactoryProvider) {
    return new DataModule_ProvideDatabaseFactory(databaseFactoryProvider);
  }

  public static TensionTrackerDatabase provideDatabase(DatabaseFactory databaseFactory) {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideDatabase(databaseFactory));
  }
}
