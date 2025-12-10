package com.keepr.app.ui.screens.home;

import androidx.lifecycle.ViewModel;
import com.keepr.app.data.repository.ApplianceRepository;
import com.keepr.app.domain.model.ApplianceUiModel;
import com.keepr.app.util.NotificationScheduler;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\rR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/keepr/app/ui/screens/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/keepr/app/data/repository/ApplianceRepository;", "notificationScheduler", "Lcom/keepr/app/util/NotificationScheduler;", "(Lcom/keepr/app/data/repository/ApplianceRepository;Lcom/keepr/app/util/NotificationScheduler;)V", "_activeAppliances", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/keepr/app/domain/model/ApplianceUiModel;", "_expiredAppliances", "_selectedTab", "", "activeAppliances", "Lkotlinx/coroutines/flow/StateFlow;", "getActiveAppliances", "()Lkotlinx/coroutines/flow/StateFlow;", "expiredAppliances", "getExpiredAppliances", "selectedTab", "getSelectedTab", "loadAppliances", "", "onDeleteAppliance", "appliance", "onTabSelected", "tabIndex", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.keepr.app.data.repository.ApplianceRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.keepr.app.util.NotificationScheduler notificationScheduler = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _selectedTab = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> selectedTab = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.keepr.app.domain.model.ApplianceUiModel>> _activeAppliances = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.keepr.app.domain.model.ApplianceUiModel>> activeAppliances = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.keepr.app.domain.model.ApplianceUiModel>> _expiredAppliances = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.keepr.app.domain.model.ApplianceUiModel>> expiredAppliances = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.keepr.app.data.repository.ApplianceRepository repository, @org.jetbrains.annotations.NotNull()
    com.keepr.app.util.NotificationScheduler notificationScheduler) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getSelectedTab() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.keepr.app.domain.model.ApplianceUiModel>> getActiveAppliances() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.keepr.app.domain.model.ApplianceUiModel>> getExpiredAppliances() {
        return null;
    }
    
    private final void loadAppliances() {
    }
    
    public final void onTabSelected(int tabIndex) {
    }
    
    public final void onDeleteAppliance(@org.jetbrains.annotations.NotNull()
    com.keepr.app.domain.model.ApplianceUiModel appliance) {
    }
}