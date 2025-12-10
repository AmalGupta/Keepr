package com.keepr.app.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.keepr.app.data.local.dao.ApplianceDao;
import dagger.internal.DaggerGenerated;
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
public final class WarrantyNotificationWorker_Factory {
  private final Provider<ApplianceDao> applianceDaoProvider;

  public WarrantyNotificationWorker_Factory(Provider<ApplianceDao> applianceDaoProvider) {
    this.applianceDaoProvider = applianceDaoProvider;
  }

  public WarrantyNotificationWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, applianceDaoProvider.get());
  }

  public static WarrantyNotificationWorker_Factory create(
      Provider<ApplianceDao> applianceDaoProvider) {
    return new WarrantyNotificationWorker_Factory(applianceDaoProvider);
  }

  public static WarrantyNotificationWorker newInstance(Context context, WorkerParameters params,
      ApplianceDao applianceDao) {
    return new WarrantyNotificationWorker(context, params, applianceDao);
  }
}
