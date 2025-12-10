package com.keepr.app.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.keepr.app.data.local.dao.ApplianceDao
import com.keepr.app.util.DateUtils
import com.keepr.app.util.NotificationHelper
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first

@HiltWorker
class WarrantyNotificationWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val applianceDao: ApplianceDao
) : CoroutineWorker(context, params) {
    
    override suspend fun doWork(): Result {
        return try {
            val applianceId = inputData.getLong("appliance_id", -1L)
            val notificationType = inputData.getString("notification_type") ?: return Result.failure()
            
            if (applianceId == -1L) {
                return Result.failure()
            }
            
            val appliance = applianceDao.getApplianceById(applianceId).first()
            
            if (appliance != null) {
                val daysUntilExpiry = DateUtils.calculateDaysUntilExpiry(appliance.warrantyEndDate)
                val message = when (notificationType) {
                    "30_days" -> "${appliance.name} warranty expires in 30 days"
                    "7_days" -> "${appliance.name} warranty expires in 7 days"
                    "expired" -> "${appliance.name} warranty has expired"
                    else -> "${appliance.name} warranty reminder"
                }
                
                NotificationHelper.showWarrantyNotification(
                    context = applicationContext,
                    notificationId = applianceId.toInt(),
                    applianceName = appliance.name,
                    daysUntilExpiry = daysUntilExpiry,
                    message = message
                )
            }
            
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }
}
