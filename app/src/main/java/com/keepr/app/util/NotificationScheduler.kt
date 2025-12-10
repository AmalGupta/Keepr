package com.keepr.app.util

import android.content.Context
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.keepr.app.worker.WarrantyNotificationWorker
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Calendar
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationScheduler @Inject constructor(
    @ApplicationContext private val context: Context,
    private val workManager: WorkManager
) {
    
    fun scheduleNotifications(applianceId: Long, warrantyEndDate: Long) {
        val currentTime = System.currentTimeMillis()
        val daysUntilExpiry = (warrantyEndDate - currentTime) / (1000 * 60 * 60 * 24)
        
        // Cancel existing notifications for this appliance
        cancelNotifications(applianceId)
        
        // Schedule 30 days before expiry
        if (daysUntilExpiry > 30) {
            val delay30Days = warrantyEndDate - (30L * 24 * 60 * 60 * 1000) - currentTime
            if (delay30Days > 0) {
                scheduleNotification(
                    applianceId = applianceId,
                    notificationType = "30_days",
                    delayMillis = delay30Days
                )
            }
        }
        
        // Schedule 7 days before expiry
        if (daysUntilExpiry > 7) {
            val delay7Days = warrantyEndDate - (7L * 24 * 60 * 60 * 1000) - currentTime
            if (delay7Days > 0) {
                scheduleNotification(
                    applianceId = applianceId,
                    notificationType = "7_days",
                    delayMillis = delay7Days
                )
            }
        }
        
        // Schedule on expiry day
        if (daysUntilExpiry >= 0) {
            val delayExpiry = warrantyEndDate - getStartOfDay(warrantyEndDate) - currentTime
            if (delayExpiry > 0) {
                scheduleNotification(
                    applianceId = applianceId,
                    notificationType = "expired",
                    delayMillis = delayExpiry
                )
            } else if (daysUntilExpiry < 0) {
                // Already expired, schedule immediately
                scheduleNotification(
                    applianceId = applianceId,
                    notificationType = "expired",
                    delayMillis = 0
                )
            }
        }
    }
    
    private fun scheduleNotification(
        applianceId: Long,
        notificationType: String,
        delayMillis: Long
    ) {
        val inputData = Data.Builder()
            .putLong("appliance_id", applianceId)
            .putString("notification_type", notificationType)
            .build()
        
        val workRequest = OneTimeWorkRequestBuilder<WarrantyNotificationWorker>()
            .setInputData(inputData)
            .setInitialDelay(delayMillis, TimeUnit.MILLISECONDS)
            .addTag("warranty_$applianceId")
            .build()
        
        workManager.enqueue(workRequest)
    }
    
    fun cancelNotifications(applianceId: Long) {
        workManager.cancelAllWorkByTag("warranty_$applianceId")
    }
    
    private fun getStartOfDay(timestamp: Long): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.timeInMillis
    }
}
