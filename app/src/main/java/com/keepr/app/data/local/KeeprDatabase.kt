package com.keepr.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keepr.app.data.local.dao.ApplianceDao
import com.keepr.app.data.local.entity.Appliance

@Database(
    entities = [Appliance::class],
    version = 1,
    exportSchema = false
)
abstract class KeeprDatabase : RoomDatabase() {
    abstract fun applianceDao(): ApplianceDao
}
