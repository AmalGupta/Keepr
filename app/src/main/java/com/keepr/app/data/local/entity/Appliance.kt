package com.keepr.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appliances")
data class Appliance(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val category: String, // Electronics, Kitchen, Vehicle, Other
    val purchaseDate: Long, // timestamp
    val warrantyEndDate: Long, // timestamp
    val modelNumber: String? = null,
    val serialNumber: String? = null,
    val vendorName: String? = null,
    val receiptImagePath: String? = null, // path to stored image
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
