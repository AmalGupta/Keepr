package com.keepr.app.di;

import com.keepr.app.data.local.dao.ApplianceDao;
import com.keepr.app.data.repository.ApplianceRepository;
import com.keepr.app.util.ImageManager;
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
public final class RepositoryModule_ProvideApplianceRepositoryFactory implements Factory<ApplianceRepository> {
  private final Provider<ApplianceDao> applianceDaoProvider;

  private final Provider<ImageManager> imageManagerProvider;

  public RepositoryModule_ProvideApplianceRepositoryFactory(
      Provider<ApplianceDao> applianceDaoProvider, Provider<ImageManager> imageManagerProvider) {
    this.applianceDaoProvider = applianceDaoProvider;
    this.imageManagerProvider = imageManagerProvider;
  }

  @Override
  public ApplianceRepository get() {
    return provideApplianceRepository(applianceDaoProvider.get(), imageManagerProvider.get());
  }

  public static RepositoryModule_ProvideApplianceRepositoryFactory create(
      Provider<ApplianceDao> applianceDaoProvider, Provider<ImageManager> imageManagerProvider) {
    return new RepositoryModule_ProvideApplianceRepositoryFactory(applianceDaoProvider, imageManagerProvider);
  }

  public static ApplianceRepository provideApplianceRepository(ApplianceDao applianceDao,
      ImageManager imageManager) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.provideApplianceRepository(applianceDao, imageManager));
  }
}
