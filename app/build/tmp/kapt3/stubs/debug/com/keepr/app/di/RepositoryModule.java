package com.keepr.app.di;

import com.keepr.app.data.local.dao.ApplianceDao;
import com.keepr.app.data.repository.ApplianceRepository;
import com.keepr.app.util.ImageManager;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lcom/keepr/app/di/RepositoryModule;", "", "()V", "provideApplianceRepository", "Lcom/keepr/app/data/repository/ApplianceRepository;", "applianceDao", "Lcom/keepr/app/data/local/dao/ApplianceDao;", "imageManager", "Lcom/keepr/app/util/ImageManager;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class RepositoryModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.keepr.app.di.RepositoryModule INSTANCE = null;
    
    private RepositoryModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.keepr.app.data.repository.ApplianceRepository provideApplianceRepository(@org.jetbrains.annotations.NotNull()
    com.keepr.app.data.local.dao.ApplianceDao applianceDao, @org.jetbrains.annotations.NotNull()
    com.keepr.app.util.ImageManager imageManager) {
        return null;
    }
}