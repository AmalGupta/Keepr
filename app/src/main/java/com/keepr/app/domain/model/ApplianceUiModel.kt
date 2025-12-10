package com.keepr.app.domain.model

import com.keepr.app.data.local.entity.Appliance
import com.keepr.app.util.DateUtils

data class ApplianceUiModel(
    val id: Long,
    val name: String,
    val category: String,
    val purchaseDate: Long,
    val warrantyEndDate: Long,
    val modelNumber: String?,
    val serialNumber: String?,
    val vendorName: String?,
    val receiptImagePath: String?,
    val createdAt: Long,
    val updatedAt: Long
) {
    val daysUntilExpiry: Int
        get() = DateUtils.calculateDaysUntilExpiry(warrantyEndDate)
    
    val isExpired: Boolean
        get() = DateUtils.isExpired(warrantyEndDate)
    
    val expiryStatus: String
        get() = DateUtils.formatExpiryStatus(warrantyEndDate)
    
    val formattedPurchaseDate: String
        get() = DateUtils.formatDate(purchaseDate)
    
    val formattedWarrantyEndDate: String
        get() = DateUtils.formatDate(warrantyEndDate)
}

fun Appliance.toUiModel(): ApplianceUiModel {
    return ApplianceUiModel(
        id = id,
        name = name,
        category = category,
        purchaseDate = purchaseDate,
        warrantyEndDate = warrantyEndDate,
        modelNumber = modelNumber,
        serialNumber = serialNumber,
        vendorName = vendorName,
        receiptImagePath = receiptImagePath,
        createdAt = createdAt,
        updatedAt = updatedAt
    )
}
