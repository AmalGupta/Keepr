package com.keepr.app.data.local.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.keepr.app.data.local.entity.Appliance;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\'J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\b2\u0006\u0010\u000e\u001a\u00020\u000bH\'J\u001e\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\'J\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/keepr/app/data/local/dao/ApplianceDao;", "", "deleteAppliance", "", "appliance", "Lcom/keepr/app/data/local/entity/Appliance;", "(Lcom/keepr/app/data/local/entity/Appliance;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveAppliances", "Lkotlinx/coroutines/flow/Flow;", "", "currentDate", "", "getAllAppliances", "getApplianceById", "id", "getExpiredAppliances", "insertAppliance", "updateAppliance", "app_debug"})
@androidx.room.Dao()
public abstract interface ApplianceDao {
    
    @androidx.room.Query(value = "SELECT * FROM appliances ORDER BY warrantyEndDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.keepr.app.data.local.entity.Appliance>> getAllAppliances();
    
    @androidx.room.Query(value = "SELECT * FROM appliances WHERE warrantyEndDate >= :currentDate ORDER BY warrantyEndDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.keepr.app.data.local.entity.Appliance>> getActiveAppliances(long currentDate);
    
    @androidx.room.Query(value = "SELECT * FROM appliances WHERE warrantyEndDate < :currentDate ORDER BY warrantyEndDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.keepr.app.data.local.entity.Appliance>> getExpiredAppliances(long currentDate);
    
    @androidx.room.Query(value = "SELECT * FROM appliances WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.keepr.app.data.local.entity.Appliance> getApplianceById(long id);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAppliance(@org.jetbrains.annotations.NotNull()
    com.keepr.app.data.local.entity.Appliance appliance, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateAppliance(@org.jetbrains.annotations.NotNull()
    com.keepr.app.data.local.entity.Appliance appliance, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAppliance(@org.jetbrains.annotations.NotNull()
    com.keepr.app.data.local.entity.Appliance appliance, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}