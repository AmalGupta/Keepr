package com.keepr.app.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.keepr.app.data.local.entity.Appliance
import kotlinx.coroutines.flow.Flow

@Dao
interface ApplianceDao {
    
    @Query("SELECT * FROM appliances ORDER BY warrantyEndDate ASC")
    fun getAllAppliances(): Flow<List<Appliance>>
    
    @Query("SELECT * FROM appliances WHERE warrantyEndDate >= :currentDate ORDER BY warrantyEndDate ASC")
    fun getActiveAppliances(currentDate: Long = System.currentTimeMillis()): Flow<List<Appliance>>
    
    @Query("SELECT * FROM appliances WHERE warrantyEndDate < :currentDate ORDER BY warrantyEndDate DESC")
    fun getExpiredAppliances(currentDate: Long = System.currentTimeMillis()): Flow<List<Appliance>>
    
    @Query("SELECT * FROM appliances WHERE id = :id")
    fun getApplianceById(id: Long): Flow<Appliance?>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppliance(appliance: Appliance): Long
    
    @Update
    suspend fun updateAppliance(appliance: Appliance)
    
    @Delete
    suspend fun deleteAppliance(appliance: Appliance)
}
