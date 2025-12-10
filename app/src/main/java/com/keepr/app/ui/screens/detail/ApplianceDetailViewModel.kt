package com.keepr.app.ui.screens.detail

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepr.app.data.repository.ApplianceRepository
import com.keepr.app.domain.model.ApplianceUiModel
import com.keepr.app.domain.model.toUiModel
import com.keepr.app.util.ImageManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApplianceDetailViewModel @Inject constructor(
    private val repository: ApplianceRepository,
    private val imageManager: ImageManager
) : ViewModel() {
    
    private val _appliance = MutableStateFlow<ApplianceUiModel?>(null)
    val appliance: StateFlow<ApplianceUiModel?> = _appliance.asStateFlow()
    
    fun loadAppliance(id: Long) {
        viewModelScope.launch {
            repository.getApplianceById(id).collect { dbAppliance ->
                _appliance.value = dbAppliance?.toUiModel()
            }
        }
    }
    
    fun getImageUri(imagePath: String): Uri? {
        return imageManager.getImageUri(imagePath)
    }
}
