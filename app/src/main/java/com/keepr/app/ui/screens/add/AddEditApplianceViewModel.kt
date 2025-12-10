package com.keepr.app.ui.screens.add

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepr.app.data.local.entity.Appliance
import com.keepr.app.data.repository.ApplianceRepository
import com.keepr.app.util.ImageManager
import com.keepr.app.util.NotificationScheduler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditApplianceViewModel @Inject constructor(
    private val repository: ApplianceRepository,
    private val imageManager: ImageManager,
    private val notificationScheduler: NotificationScheduler
) : ViewModel() {
    
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name.asStateFlow()
    
    private val _category = MutableStateFlow("Electronics")
    val category: StateFlow<String> = _category.asStateFlow()
    
    private val _purchaseDate = MutableStateFlow<Long?>(null)
    val purchaseDate: StateFlow<Long?> = _purchaseDate.asStateFlow()
    
    private val _warrantyEndDate = MutableStateFlow<Long?>(null)
    val warrantyEndDate: StateFlow<Long?> = _warrantyEndDate.asStateFlow()
    
    private val _modelNumber = MutableStateFlow("")
    val modelNumber: StateFlow<String> = _modelNumber.asStateFlow()
    
    private val _serialNumber = MutableStateFlow("")
    val serialNumber: StateFlow<String> = _serialNumber.asStateFlow()
    
    private val _vendorName = MutableStateFlow("")
    val vendorName: StateFlow<String> = _vendorName.asStateFlow()
    
    private val _receiptImageUri = MutableStateFlow<Uri?>(null)
    val receiptImageUri: StateFlow<Uri?> = _receiptImageUri.asStateFlow()
    
    private val _receiptImagePath = MutableStateFlow<String?>(null)
    val receiptImagePath: StateFlow<String?> = _receiptImagePath.asStateFlow()
    
    private val _isEditMode = MutableStateFlow(false)
    val isEditMode: StateFlow<Boolean> = _isEditMode.asStateFlow()
    
    private val _applianceId = MutableStateFlow<Long?>(null)
    val applianceId: StateFlow<Long?> = _applianceId.asStateFlow()
    
    fun loadAppliance(id: Long) {
        viewModelScope.launch {
            repository.getApplianceById(id).collect { appliance ->
                appliance?.let {
                    _applianceId.value = it.id
                    _name.value = it.name
                    _category.value = it.category
                    _purchaseDate.value = it.purchaseDate
                    _warrantyEndDate.value = it.warrantyEndDate
                    _modelNumber.value = it.modelNumber ?: ""
                    _serialNumber.value = it.serialNumber ?: ""
                    _vendorName.value = it.vendorName ?: ""
                    _receiptImagePath.value = it.receiptImagePath
                    _isEditMode.value = true
                    
                    // Load image URI if path exists
                    it.receiptImagePath?.let { path ->
                        imageManager.getImageUri(path)?.let { uri ->
                            _receiptImageUri.value = uri
                        }
                    }
                }
            }
        }
    }
    
    fun setName(name: String) {
        _name.value = name
    }
    
    fun setCategory(category: String) {
        _category.value = category
    }
    
    fun setPurchaseDate(timestamp: Long) {
        _purchaseDate.value = timestamp
    }
    
    fun setWarrantyEndDate(timestamp: Long) {
        _warrantyEndDate.value = timestamp
    }
    
    fun setModelNumber(modelNumber: String) {
        _modelNumber.value = modelNumber
    }
    
    fun setSerialNumber(serialNumber: String) {
        _serialNumber.value = serialNumber
    }
    
    fun setVendorName(vendorName: String) {
        _vendorName.value = vendorName
    }
    
    fun onImageSelected(uri: Uri) {
        _receiptImageUri.value = uri
        viewModelScope.launch {
            val imagePath = imageManager.saveImageFromUri(uri)
            _receiptImagePath.value = imagePath
        }
    }
    
    suspend fun onSave(): Boolean {
        if (!validateForm()) {
            return false
        }
        
        val purchaseDateValue = _purchaseDate.value ?: return false
        val warrantyEndDateValue = _warrantyEndDate.value ?: return false
        
        val appliance = Appliance(
            id = _applianceId.value ?: 0L,
            name = _name.value.trim(),
            category = _category.value,
            purchaseDate = purchaseDateValue,
            warrantyEndDate = warrantyEndDateValue,
            modelNumber = _modelNumber.value.takeIf { it.isNotBlank() },
            serialNumber = _serialNumber.value.takeIf { it.isNotBlank() },
            vendorName = _vendorName.value.takeIf { it.isNotBlank() },
            receiptImagePath = _receiptImagePath.value,
            createdAt = if (_isEditMode.value) System.currentTimeMillis() else System.currentTimeMillis(),
            updatedAt = System.currentTimeMillis()
        )
        
        return if (_isEditMode.value && _applianceId.value != null) {
            val result = repository.updateAppliance(appliance)
            if (result.isSuccess) {
                // Reschedule notifications
                notificationScheduler.scheduleNotifications(appliance.id, appliance.warrantyEndDate)
                true
            } else {
                false
            }
        } else {
            val result = repository.insertAppliance(appliance)
            if (result.isSuccess) {
                val id = result.getOrNull() ?: return false
                // Schedule notifications
                notificationScheduler.scheduleNotifications(id, warrantyEndDateValue)
                true
            } else {
                false
            }
        }
    }
    
    fun validateForm(): Boolean {
        return _name.value.isNotBlank() &&
                _purchaseDate.value != null &&
                _warrantyEndDate.value != null &&
                _category.value.isNotBlank()
    }
    
    fun reset() {
        _name.value = ""
        _category.value = "Electronics"
        _purchaseDate.value = null
        _warrantyEndDate.value = null
        _modelNumber.value = ""
        _serialNumber.value = ""
        _vendorName.value = ""
        _receiptImageUri.value = null
        _receiptImagePath.value = null
        _isEditMode.value = false
        _applianceId.value = null
    }
}
