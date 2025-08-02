package com.tuv.tensiontracker.data.di;

import android.content.Context;
import com.tuv.tensiontracker.data.database.TensionTrackerDatabase;
import com.tuv.tensiontracker.domain.repository.StringCatalogRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DataModule_ProvideStringCatalogRepositoryFactory implements Factory<StringCatalogRepository> {
  private final Provider<TensionTrackerDatabase> databaseProvider;

  private final Provider<Context> contextProvider;

  public DataModule_ProvideStringCatalogRepositoryFactory(
      Provider<TensionTrackerDatabase> databaseProvider, Provider<Context> contextProvider) {
    this.databaseProvider = databaseProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public StringCatalogRepository get() {
    return provideStringCatalogRepository(databaseProvider.get(), contextProvider.get());
  }

  public static DataModule_ProvideStringCatalogRepositoryFactory create(
      Provider<TensionTrackerDatabase> databaseProvider, Provider<Context> contextProvider) {
    return new DataModule_ProvideStringCatalogRepositoryFactory(databaseProvider, contextProvider);
  }

  public static StringCatalogRepository provideStringCatalogRepository(
      TensionTrackerDatabase database, Context context) {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideStringCatalogRepository(database, context));
  }
}
