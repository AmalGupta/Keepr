package com.keepr.app.di;

import com.keepr.app.data.local.KeeprDatabase;
import com.keepr.app.data.local.dao.ApplianceDao;
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
    "KotlinInternalInJava"
})
public final class DatabaseModule_ProvideApplianceDaoFactory implements Factory<ApplianceDao> {
  private final Provider<KeeprDatabase> databaseProvider;

  public DatabaseModule_ProvideApplianceDaoFactory(Provider<KeeprDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ApplianceDao get() {
    return provideApplianceDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideApplianceDaoFactory create(
      Provider<KeeprDatabase> databaseProvider) {
    return new DatabaseModule_ProvideApplianceDaoFactory(databaseProvider);
  }

  public static ApplianceDao provideApplianceDao(KeeprDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideApplianceDao(database));
  }
}
