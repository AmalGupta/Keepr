package com.keepr.app.ui.screens.home;

import com.keepr.app.data.repository.ApplianceRepository;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<ApplianceRepository> repositoryProvider;

  private final Provider<NotificationScheduler> notificationSchedulerProvider;

  public HomeViewModel_Factory(Provider<ApplianceRepository> repositoryProvider,
      Provider<NotificationScheduler> notificationSchedulerProvider) {
    this.repositoryProvider = repositoryProvider;
    this.notificationSchedulerProvider = notificationSchedulerProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(repositoryProvider.get(), notificationSchedulerProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<ApplianceRepository> repositoryProvider,
      Provider<NotificationScheduler> notificationSchedulerProvider) {
    return new HomeViewModel_Factory(repositoryProvider, notificationSchedulerProvider);
  }

  public static HomeViewModel newInstance(ApplianceRepository repository,
      NotificationScheduler notificationScheduler) {
    return new HomeViewModel(repository, notificationScheduler);
  }
}
