package com.keepr.app.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class WarrantyNotificationWorker_AssistedFactory_Impl implements WarrantyNotificationWorker_AssistedFactory {
  private final WarrantyNotificationWorker_Factory delegateFactory;

  WarrantyNotificationWorker_AssistedFactory_Impl(
      WarrantyNotificationWorker_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public WarrantyNotificationWorker create(Context arg0, WorkerParameters arg1) {
    return delegateFactory.get(arg0, arg1);
  }

  public static Provider<WarrantyNotificationWorker_AssistedFactory> create(
      WarrantyNotificationWorker_Factory delegateFactory) {
    return InstanceFactory.create(new WarrantyNotificationWorker_AssistedFactory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<WarrantyNotificationWorker_AssistedFactory> createFactoryProvider(
      WarrantyNotificationWorker_Factory delegateFactory) {
    return InstanceFactory.create(new WarrantyNotificationWorker_AssistedFactory_Impl(delegateFactory));
  }
}
