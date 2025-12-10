package com.keepr.app

import android.app.Application
import com.keepr.app.util.NotificationHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KeeprApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        // Create notification channel
        NotificationHelper.createNotificationChannel(this)
        
        // Note: Notification scheduling will be done when appliances are added/updated
        // This is handled in the repository/ViewModel layer
    }
}
