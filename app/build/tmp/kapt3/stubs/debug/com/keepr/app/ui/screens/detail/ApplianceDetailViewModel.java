package com.keepr.app.ui.screens.detail;

import android.net.Uri;
import androidx.lifecycle.ViewModel;
import com.keepr.app.data.repository.ApplianceRepository;
import com.keepr.app.domain.model.ApplianceUiModel;
import com.keepr.app.util.ImageManager;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/keepr/app/ui/screens/detail/ApplianceDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/keepr/app/data/repository/ApplianceRepository;", "imageManager", "Lcom/keepr/app/util/ImageManager;", "(Lcom/keepr/app/data/repository/ApplianceRepository;Lcom/keepr/app/util/ImageManager;)V", "_appliance", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/keepr/app/domain/model/ApplianceUiModel;", "appliance", "Lkotlinx/coroutines/flow/StateFlow;", "getAppliance", "()Lkotlinx/coroutines/flow/StateFlow;", "getImageUri", "Landroid/net/Uri;", "imagePath", "", "loadAppliance", "", "id", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ApplianceDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.keepr.app.data.repository.ApplianceRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.keepr.app.util.ImageManager imageManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.keepr.app.domain.model.ApplianceUiModel> _appliance = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.keepr.app.domain.model.ApplianceUiModel> appliance = null;
    
    @javax.inject.Inject()
    public ApplianceDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.keepr.app.data.repository.ApplianceRepository repository, @org.jetbrains.annotations.NotNull()
    com.keepr.app.util.ImageManager imageManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.keepr.app.domain.model.ApplianceUiModel> getAppliance() {
        return null;
    }
    
    public final void loadAppliance(long id) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getImageUri(@org.jetbrains.annotations.NotNull()
    java.lang.String imagePath) {
        return null;
    }
}