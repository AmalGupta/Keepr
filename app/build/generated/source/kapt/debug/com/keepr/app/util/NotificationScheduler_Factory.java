package com.keepr.app.util;

import android.content.Context;
import androidx.work.WorkManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
    "KotlinInternalInJava"
})
public final class NotificationScheduler_Factory implements Factory<NotificationScheduler> {
  private final Provider<Context> contextProvider;

  private final Provider<WorkManager> workManagerProvider;

  public NotificationScheduler_Factory(Provider<Context> contextProvider,
      Provider<WorkManager> workManagerProvider) {
    this.contextProvider = contextProvider;
    this.workManagerProvider = workManagerProvider;
  }

  @Override
  public NotificationScheduler get() {
    return newInstance(contextProvider.get(), workManagerProvider.get());
  }

  public static NotificationScheduler_Factory create(Provider<Context> contextProvider,
      Provider<WorkManager> workManagerProvider) {
    return new NotificationScheduler_Factory(contextProvider, workManagerProvider);
  }

  public static NotificationScheduler newInstance(Context context, WorkManager workManager) {
    return new NotificationScheduler(context, workManager);
  }
}
