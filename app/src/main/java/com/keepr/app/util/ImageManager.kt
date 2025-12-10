package com.keepr.app.util

import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.core.content.FileProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageManager @Inject constructor(
    private val context: Context
) {
    
    private val receiptsDir: File
        get() = File(context.filesDir, "receipts").apply {
            if (!exists()) {
                mkdirs()
            }
        }
    
    fun getFileProviderUri(file: File): Uri {
        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            file
        )
    }
    
    suspend fun saveImageFromUri(uri: Uri): String? = withContext(Dispatchers.IO) {
        try {
            val fileName = "${UUID.randomUUID()}.jpg"
            val outputFile = File(receiptsDir, fileName)
            
            context.contentResolver.openInputStream(uri)?.use { inputStream ->
                FileOutputStream(outputFile).use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
            
            outputFile.absolutePath
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
    
    suspend fun deleteImage(imagePath: String?): Boolean = withContext(Dispatchers.IO) {
        if (imagePath.isNullOrBlank()) return@withContext true
        
        try {
            val file = File(imagePath)
            if (file.exists()) {
                file.delete()
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }
    
    fun getImageUri(imagePath: String?): Uri? {
        if (imagePath.isNullOrBlank()) return null
        
        val file = File(imagePath)
        return if (file.exists()) {
            getFileProviderUri(file)
        } else {
            null
        }
    }
    
    fun createImageFile(): File {
        val fileName = "${UUID.randomUUID()}.jpg"
        return File(receiptsDir, fileName)
    }
}
