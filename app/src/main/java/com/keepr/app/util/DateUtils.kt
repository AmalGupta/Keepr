package com.keepr.app.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

object DateUtils {
    
    private val dateFormatter = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
    private val dateTimeFormatter = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
    
    fun formatDate(timestamp: Long): String {
        return dateFormatter.format(Date(timestamp))
    }
    
    fun formatDateTime(timestamp: Long): String {
        return dateTimeFormatter.format(Date(timestamp))
    }
    
    fun calculateDaysUntilExpiry(warrantyEndDate: Long): Int {
        val currentTime = System.currentTimeMillis()
        val diff = warrantyEndDate - currentTime
        return (diff / (1000 * 60 * 60 * 24)).toInt()
    }
    
    fun formatExpiryStatus(warrantyEndDate: Long): String {
        val daysUntilExpiry = calculateDaysUntilExpiry(warrantyEndDate)
        
        return when {
            daysUntilExpiry < 0 -> "Expired"
            daysUntilExpiry == 0 -> "Expires Today"
            daysUntilExpiry <= 7 -> "D-$daysUntilExpiry"
            daysUntilExpiry <= 30 -> "D-$daysUntilExpiry"
            else -> "D-$daysUntilExpiry"
        }
    }
    
    fun isExpired(warrantyEndDate: Long): Boolean {
        return calculateDaysUntilExpiry(warrantyEndDate) < 0
    }
    
    fun getStartOfDay(timestamp: Long): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.timeInMillis
    }
}
