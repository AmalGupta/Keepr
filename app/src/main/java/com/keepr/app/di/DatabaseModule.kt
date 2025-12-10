package com.keepr.app.di

import android.content.Context
import androidx.room.Room
import com.keepr.app.data.local.KeeprDatabase
import com.keepr.app.data.local.dao.ApplianceDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): KeeprDatabase {
        return Room.databaseBuilder(
            context,
            KeeprDatabase::class.java,
            "keepr_database"
        ).build()
    }
    
    @Provides
    @Singleton
    fun provideApplianceDao(database: KeeprDatabase): ApplianceDao {
        return database.applianceDao()
    }
}
