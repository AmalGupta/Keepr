package com.keepr.app.ui.screens.add;

import android.net.Uri;
import androidx.lifecycle.ViewModel;
import com.keepr.app.data.local.entity.Appliance;
import com.keepr.app.data.repository.ApplianceRepository;
import com.keepr.app.util.ImageManager;
import com.keepr.app.util.NotificationScheduler;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000bJ\u000e\u00103\u001a\u0002012\u0006\u00104\u001a\u00020\u0015J\u000e\u00105\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u00106J\u0006\u00107\u001a\u000201J\u000e\u00108\u001a\u0002012\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u00109\u001a\u0002012\u0006\u0010 \u001a\u00020\rJ\u000e\u0010:\u001a\u0002012\u0006\u0010\"\u001a\u00020\rJ\u000e\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020\u000bJ\u000e\u0010=\u001a\u0002012\u0006\u0010*\u001a\u00020\rJ\u000e\u0010>\u001a\u0002012\u0006\u0010,\u001a\u00020\rJ\u000e\u0010?\u001a\u0002012\u0006\u0010<\u001a\u00020\u000bJ\u0006\u0010@\u001a\u00020\u000fR\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001cR\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\r0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0019\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001c\u00a8\u0006A"}, d2 = {"Lcom/keepr/app/ui/screens/add/AddEditApplianceViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/keepr/app/data/repository/ApplianceRepository;", "imageManager", "Lcom/keepr/app/util/ImageManager;", "notificationScheduler", "Lcom/keepr/app/util/NotificationScheduler;", "(Lcom/keepr/app/data/repository/ApplianceRepository;Lcom/keepr/app/util/ImageManager;Lcom/keepr/app/util/NotificationScheduler;)V", "_applianceId", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_category", "", "_isEditMode", "", "_modelNumber", "_name", "_purchaseDate", "_receiptImagePath", "_receiptImageUri", "Landroid/net/Uri;", "_serialNumber", "_vendorName", "_warrantyEndDate", "applianceId", "Lkotlinx/coroutines/flow/StateFlow;", "getApplianceId", "()Lkotlinx/coroutines/flow/StateFlow;", "category", "getCategory", "isEditMode", "modelNumber", "getModelNumber", "name", "getName", "purchaseDate", "getPurchaseDate", "receiptImagePath", "getReceiptImagePath", "receiptImageUri", "getReceiptImageUri", "serialNumber", "getSerialNumber", "vendorName", "getVendorName", "warrantyEndDate", "getWarrantyEndDate", "loadAppliance", "", "id", "onImageSelected", "uri", "onSave", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reset", "setCategory", "setModelNumber", "setName", "setPurchaseDate", "timestamp", "setSerialNumber", "setVendorName", "setWarrantyEndDate", "validateForm", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AddEditApplianceViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.keepr.app.data.repository.ApplianceRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.keepr.app.util.ImageManager imageManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.keepr.app.util.NotificationScheduler notificationScheduler = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _name = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> name = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _category = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> category = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Long> _purchaseDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> purchaseDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Long> _warrantyEndDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> warrantyEndDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _modelNumber = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> modelNumber = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _serialNumber = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> serialNumber = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _vendorName = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> vendorName = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<android.net.Uri> _receiptImageUri = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<android.net.Uri> receiptImageUri = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _receiptImagePath = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> receiptImagePath = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isEditMode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isEditMode = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Long> _applianceId = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> applianceId = null;
    
    @javax.inject.Inject()
    public AddEditApplianceViewModel(@org.jetbrains.annotations.NotNull()
    com.keepr.app.data.repository.ApplianceRepository repository, @org.jetbrains.annotations.NotNull()
    com.keepr.app.util.ImageManager imageManager, @org.jetbrains.annotations.NotNull()
    com.keepr.app.util.NotificationScheduler notificationScheduler) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getPurchaseDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getWarrantyEndDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getModelNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSerialNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getVendorName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<android.net.Uri> getReceiptImageUri() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getReceiptImagePath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isEditMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getApplianceId() {
        return null;
    }
    
    public final void loadAppliance(long id) {
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void setCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
    }
    
    public final void setPurchaseDate(long timestamp) {
    }
    
    public final void setWarrantyEndDate(long timestamp) {
    }
    
    public final void setModelNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String modelNumber) {
    }
    
    public final void setSerialNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String serialNumber) {
    }
    
    public final void setVendorName(@org.jetbrains.annotations.NotNull()
    java.lang.String vendorName) {
    }
    
    public final void onImageSelected(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object onSave(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    public final boolean validateForm() {
        return false;
    }
    
    public final void reset() {
    }
}