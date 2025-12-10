package com.keepr.app.di

import com.keepr.app.data.local.dao.ApplianceDao
import com.keepr.app.data.repository.ApplianceRepository
import com.keepr.app.util.ImageManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    
    @Provides
    @Singleton
    fun provideApplianceRepository(
        applianceDao: ApplianceDao,
        imageManager: ImageManager
    ): ApplianceRepository {
        return ApplianceRepository(applianceDao, imageManager)
    }
}
