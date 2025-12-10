package com.keepr.app.data.repository;

import com.keepr.app.data.local.dao.ApplianceDao;
import com.keepr.app.util.ImageManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class ApplianceRepository_Factory implements Factory<ApplianceRepository> {
  private final Provider<ApplianceDao> applianceDaoProvider;

  private final Provider<ImageManager> imageManagerProvider;

  public ApplianceRepository_Factory(Provider<ApplianceDao> applianceDaoProvider,
      Provider<ImageManager> imageManagerProvider) {
    this.applianceDaoProvider = applianceDaoProvider;
    this.imageManagerProvider = imageManagerProvider;
  }

  @Override
  public ApplianceRepository get() {
    return newInstance(applianceDaoProvider.get(), imageManagerProvider.get());
  }

  public static ApplianceRepository_Factory create(Provider<ApplianceDao> applianceDaoProvider,
      Provider<ImageManager> imageManagerProvider) {
    return new ApplianceRepository_Factory(applianceDaoProvider, imageManagerProvider);
  }

  public static ApplianceRepository newInstance(ApplianceDao applianceDao,
      ImageManager imageManager) {
    return new ApplianceRepository(applianceDao, imageManager);
  }
}
