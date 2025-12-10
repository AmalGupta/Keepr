package com.keepr.app.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.keepr.app.data.local.dao.ApplianceDao;
import com.keepr.app.data.local.entity.Appliance;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/keepr/app/data/local/KeeprDatabase;", "Landroidx/room/RoomDatabase;", "()V", "applianceDao", "Lcom/keepr/app/data/local/dao/ApplianceDao;", "app_debug"})
@androidx.room.Database(entities = {com.keepr.app.data.local.entity.Appliance.class}, version = 1, exportSchema = false)
public abstract class KeeprDatabase extends androidx.room.RoomDatabase {
    
    public KeeprDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.keepr.app.data.local.dao.ApplianceDao applianceDao();
}