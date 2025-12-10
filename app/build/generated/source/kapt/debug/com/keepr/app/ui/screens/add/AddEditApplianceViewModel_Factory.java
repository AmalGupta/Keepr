package com.keepr.app.ui.screens.add;

import com.keepr.app.data.repository.ApplianceRepository;
import com.keepr.app.util.ImageManager;
import com.keepr.app.util.NotificationScheduler;
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
public final class AddEditApplianceViewModel_Factory implements Factory<AddEditApplianceViewModel> {
  private final Provider<ApplianceRepository> repositoryProvider;

  private final Provider<ImageManager> imageManagerProvider;

  private final Provider<NotificationScheduler> notificationSchedulerProvider;

  public AddEditApplianceViewModel_Factory(Provider<ApplianceRepository> repositoryProvider,
      Provider<ImageManager> imageManagerProvider,
      Provider<NotificationScheduler> notificationSchedulerProvider) {
    this.repositoryProvider = repositoryProvider;
    this.imageManagerProvider = imageManagerProvider;
    this.notificationSchedulerProvider = notificationSchedulerProvider;
  }

  @Override
  public AddEditApplianceViewModel get() {
    return newInstance(repositoryProvider.get(), imageManagerProvider.get(), notificationSchedulerProvider.get());
  }

  public static AddEditApplianceViewModel_Factory create(
      Provider<ApplianceRepository> repositoryProvider, Provider<ImageManager> imageManagerProvider,
      Provider<NotificationScheduler> notificationSchedulerProvider) {
    return new AddEditApplianceViewModel_Factory(repositoryProvider, imageManagerProvider, notificationSchedulerProvider);
  }

  public static AddEditApplianceViewModel newInstance(ApplianceRepository repository,
      ImageManager imageManager, NotificationScheduler notificationScheduler) {
    return new AddEditApplianceViewModel(repository, imageManager, notificationScheduler);
  }
}
