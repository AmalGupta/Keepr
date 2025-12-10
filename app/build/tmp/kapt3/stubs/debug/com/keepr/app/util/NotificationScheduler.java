package com.keepr.app.util;

import android.content.Context;
import androidx.work.Data;
import androidx.work.WorkManager;
import com.keepr.app.worker.WarrantyNotificationWorker;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J \u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/keepr/app/util/NotificationScheduler;", "", "context", "Landroid/content/Context;", "workManager", "Landroidx/work/WorkManager;", "(Landroid/content/Context;Landroidx/work/WorkManager;)V", "cancelNotifications", "", "applianceId", "", "getStartOfDay", "timestamp", "scheduleNotification", "notificationType", "", "delayMillis", "scheduleNotifications", "warrantyEndDate", "app_debug"})
public final class NotificationScheduler {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.work.WorkManager workManager = null;
    
    @javax.inject.Inject()
    public NotificationScheduler(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.work.WorkManager workManager) {
        super();
    }
    
    public final void scheduleNotifications(long applianceId, long warrantyEndDate) {
    }
    
    private final void scheduleNotification(long applianceId, java.lang.String notificationType, long delayMillis) {
    }
    
    public final void cancelNotifications(long applianceId) {
    }
    
    private final long getStartOfDay(long timestamp) {
        return 0L;
    }
}