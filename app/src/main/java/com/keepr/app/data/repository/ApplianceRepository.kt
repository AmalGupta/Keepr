package com.keepr.app.data.repository

import com.keepr.app.data.local.dao.ApplianceDao
import com.keepr.app.data.local.entity.Appliance
import com.keepr.app.util.ImageManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApplianceRepository @Inject constructor(
    private val applianceDao: ApplianceDao,
    private val imageManager: ImageManager
) {
    
    fun getAllAppliances(): Flow<List<Appliance>> {
        return applianceDao.getAllAppliances()
    }
    
    fun getActiveAppliances(): Flow<List<Appliance>> {
        return applianceDao.getActiveAppliances()
    }
    
    fun getExpiredAppliances(): Flow<List<Appliance>> {
        return applianceDao.getExpiredAppliances()
    }
    
    fun getApplianceById(id: Long): Flow<Appliance?> {
        return applianceDao.getApplianceById(id)
    }
    
    suspend fun insertAppliance(appliance: Appliance): Result<Long> {
        return try {
            val id = applianceDao.insertAppliance(appliance)
            Result.success(id)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun updateAppliance(appliance: Appliance): Result<Unit> {
        return try {
            val updatedAppliance = appliance.copy(updatedAt = System.currentTimeMillis())
            applianceDao.updateAppliance(updatedAppliance)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun deleteAppliance(appliance: Appliance): Result<Unit> {
        return try {
            // Delete associated image
            appliance.receiptImagePath?.let { imagePath ->
                imageManager.deleteImage(imagePath)
            }
            applianceDao.deleteAppliance(appliance)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
