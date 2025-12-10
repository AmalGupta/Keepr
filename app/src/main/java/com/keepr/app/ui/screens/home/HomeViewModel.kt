package com.keepr.app.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keepr.app.data.repository.ApplianceRepository
import com.keepr.app.domain.model.ApplianceUiModel
import com.keepr.app.domain.model.toUiModel
import com.keepr.app.util.NotificationScheduler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ApplianceRepository,
    private val notificationScheduler: NotificationScheduler
) : ViewModel() {
    
    private val _selectedTab = MutableStateFlow(0) // 0 = Active, 1 = Expired
    val selectedTab: StateFlow<Int> = _selectedTab.asStateFlow()
    
    private val _activeAppliances = MutableStateFlow<List<ApplianceUiModel>>(emptyList())
    val activeAppliances: StateFlow<List<ApplianceUiModel>> = _activeAppliances.asStateFlow()
    
    private val _expiredAppliances = MutableStateFlow<List<ApplianceUiModel>>(emptyList())
    val expiredAppliances: StateFlow<List<ApplianceUiModel>> = _expiredAppliances.asStateFlow()
    
    init {
        loadAppliances()
    }
    
    private fun loadAppliances() {
        viewModelScope.launch {
            repository.getActiveAppliances().collect { appliances ->
                _activeAppliances.value = appliances.map { it.toUiModel() }
            }
        }
        
        viewModelScope.launch {
            repository.getExpiredAppliances().collect { appliances ->
                _expiredAppliances.value = appliances.map { it.toUiModel() }
            }
        }
    }
    
    fun onTabSelected(tabIndex: Int) {
        _selectedTab.value = tabIndex
    }
    
    fun onDeleteAppliance(appliance: ApplianceUiModel) {
        viewModelScope.launch {
            // Cancel notifications first
            notificationScheduler.cancelNotifications(appliance.id)
            // Get appliance from repository and delete
            val dbAppliance = repository.getApplianceById(appliance.id).first()
            dbAppliance?.let {
                repository.deleteAppliance(it)
            }
        }
    }
}
