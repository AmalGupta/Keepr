package com.keepr.app.data.repository;

import com.keepr.app.data.local.dao.ApplianceDao;
import com.keepr.app.data.local.entity.Appliance;
import com.keepr.app.util.ImageManager;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u000fJ\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u000fJ\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00100\u000fJ$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0017\u0010\rJ$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0019\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001a"}, d2 = {"Lcom/keepr/app/data/repository/ApplianceRepository;", "", "applianceDao", "Lcom/keepr/app/data/local/dao/ApplianceDao;", "imageManager", "Lcom/keepr/app/util/ImageManager;", "(Lcom/keepr/app/data/local/dao/ApplianceDao;Lcom/keepr/app/util/ImageManager;)V", "deleteAppliance", "Lkotlin/Result;", "", "appliance", "Lcom/keepr/app/data/local/entity/Appliance;", "deleteAppliance-gIAlu-s", "(Lcom/keepr/app/data/local/entity/Appliance;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveAppliances", "Lkotlinx/coroutines/flow/Flow;", "", "getAllAppliances", "getApplianceById", "id", "", "getExpiredAppliances", "insertAppliance", "insertAppliance-gIAlu-s", "updateAppliance", "updateAppliance-gIAlu-s", "app_debug"})
public final class ApplianceRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.keepr.app.data.local.dao.ApplianceDao applianceDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.keepr.app.util.ImageManager imageManager = null;
    
    @javax.inject.Inject()
    public ApplianceRepository(@org.jetbrains.annotations.NotNull()
    com.keepr.app.data.local.dao.ApplianceDao applianceDao, @org.jetbrains.annotations.NotNull()
    com.keepr.app.util.ImageManager imageManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.keepr.app.data.local.entity.Appliance>> getAllAppliances() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.keepr.app.data.local.entity.Appliance>> getActiveAppliances() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.keepr.app.data.local.entity.Appliance>> getExpiredAppliances() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.keepr.app.data.local.entity.Appliance> getApplianceById(long id) {
        return null;
    }
}