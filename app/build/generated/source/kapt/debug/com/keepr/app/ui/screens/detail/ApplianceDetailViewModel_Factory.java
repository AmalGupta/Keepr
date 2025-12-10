package com.keepr.app.ui.screens.detail;

import com.keepr.app.data.repository.ApplianceRepository;
import com.keepr.app.util.ImageManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class ApplianceDetailViewModel_Factory implements Factory<ApplianceDetailViewModel> {
  private final Provider<ApplianceRepository> repositoryProvider;

  private final Provider<ImageManager> imageManagerProvider;

  public ApplianceDetailViewModel_Factory(Provider<ApplianceRepository> repositoryProvider,
      Provider<ImageManager> imageManagerProvider) {
    this.repositoryProvider = repositoryProvider;
    this.imageManagerProvider = imageManagerProvider;
  }

  @Override
  public ApplianceDetailViewModel get() {
    return newInstance(repositoryProvider.get(), imageManagerProvider.get());
  }

  public static ApplianceDetailViewModel_Factory create(
      Provider<ApplianceRepository> repositoryProvider,
      Provider<ImageManager> imageManagerProvider) {
    return new ApplianceDetailViewModel_Factory(repositoryProvider, imageManagerProvider);
  }

  public static ApplianceDetailViewModel newInstance(ApplianceRepository repository,
      ImageManager imageManager) {
    return new ApplianceDetailViewModel(repository, imageManager);
  }
}
