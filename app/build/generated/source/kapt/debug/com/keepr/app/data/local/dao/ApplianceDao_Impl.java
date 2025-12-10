package com.keepr.app.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.keepr.app.data.local.entity.Appliance;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ApplianceDao_Impl implements ApplianceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Appliance> __insertionAdapterOfAppliance;

  private final EntityDeletionOrUpdateAdapter<Appliance> __deletionAdapterOfAppliance;

  private final EntityDeletionOrUpdateAdapter<Appliance> __updateAdapterOfAppliance;

  public ApplianceDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAppliance = new EntityInsertionAdapter<Appliance>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `appliances` (`id`,`name`,`category`,`purchaseDate`,`warrantyEndDate`,`modelNumber`,`serialNumber`,`vendorName`,`receiptImagePath`,`createdAt`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Appliance entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCategory());
        }
        statement.bindLong(4, entity.getPurchaseDate());
        statement.bindLong(5, entity.getWarrantyEndDate());
        if (entity.getModelNumber() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getModelNumber());
        }
        if (entity.getSerialNumber() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getSerialNumber());
        }
        if (entity.getVendorName() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getVendorName());
        }
        if (entity.getReceiptImagePath() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getReceiptImagePath());
        }
        statement.bindLong(10, entity.getCreatedAt());
        statement.bindLong(11, entity.getUpdatedAt());
      }
    };
    this.__deletionAdapterOfAppliance = new EntityDeletionOrUpdateAdapter<Appliance>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `appliances` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Appliance entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfAppliance = new EntityDeletionOrUpdateAdapter<Appliance>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `appliances` SET `id` = ?,`name` = ?,`category` = ?,`purchaseDate` = ?,`warrantyEndDate` = ?,`modelNumber` = ?,`serialNumber` = ?,`vendorName` = ?,`receiptImagePath` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Appliance entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCategory());
        }
        statement.bindLong(4, entity.getPurchaseDate());
        statement.bindLong(5, entity.getWarrantyEndDate());
        if (entity.getModelNumber() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getModelNumber());
        }
        if (entity.getSerialNumber() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getSerialNumber());
        }
        if (entity.getVendorName() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getVendorName());
        }
        if (entity.getReceiptImagePath() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getReceiptImagePath());
        }
        statement.bindLong(10, entity.getCreatedAt());
        statement.bindLong(11, entity.getUpdatedAt());
        statement.bindLong(12, entity.getId());
      }
    };
  }

  @Override
  public Object insertAppliance(final Appliance appliance,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfAppliance.insertAndReturnId(appliance);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAppliance(final Appliance appliance,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfAppliance.handle(appliance);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateAppliance(final Appliance appliance,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfAppliance.handle(appliance);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Appliance>> getAllAppliances() {
    final String _sql = "SELECT * FROM appliances ORDER BY warrantyEndDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"appliances"}, new Callable<List<Appliance>>() {
      @Override
      @NonNull
      public List<Appliance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPurchaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "purchaseDate");
          final int _cursorIndexOfWarrantyEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyEndDate");
          final int _cursorIndexOfModelNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "modelNumber");
          final int _cursorIndexOfSerialNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "serialNumber");
          final int _cursorIndexOfVendorName = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorName");
          final int _cursorIndexOfReceiptImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptImagePath");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Appliance> _result = new ArrayList<Appliance>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Appliance _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final long _tmpPurchaseDate;
            _tmpPurchaseDate = _cursor.getLong(_cursorIndexOfPurchaseDate);
            final long _tmpWarrantyEndDate;
            _tmpWarrantyEndDate = _cursor.getLong(_cursorIndexOfWarrantyEndDate);
            final String _tmpModelNumber;
            if (_cursor.isNull(_cursorIndexOfModelNumber)) {
              _tmpModelNumber = null;
            } else {
              _tmpModelNumber = _cursor.getString(_cursorIndexOfModelNumber);
            }
            final String _tmpSerialNumber;
            if (_cursor.isNull(_cursorIndexOfSerialNumber)) {
              _tmpSerialNumber = null;
            } else {
              _tmpSerialNumber = _cursor.getString(_cursorIndexOfSerialNumber);
            }
            final String _tmpVendorName;
            if (_cursor.isNull(_cursorIndexOfVendorName)) {
              _tmpVendorName = null;
            } else {
              _tmpVendorName = _cursor.getString(_cursorIndexOfVendorName);
            }
            final String _tmpReceiptImagePath;
            if (_cursor.isNull(_cursorIndexOfReceiptImagePath)) {
              _tmpReceiptImagePath = null;
            } else {
              _tmpReceiptImagePath = _cursor.getString(_cursorIndexOfReceiptImagePath);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new Appliance(_tmpId,_tmpName,_tmpCategory,_tmpPurchaseDate,_tmpWarrantyEndDate,_tmpModelNumber,_tmpSerialNumber,_tmpVendorName,_tmpReceiptImagePath,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Appliance>> getActiveAppliances(final long currentDate) {
    final String _sql = "SELECT * FROM appliances WHERE warrantyEndDate >= ? ORDER BY warrantyEndDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, currentDate);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"appliances"}, new Callable<List<Appliance>>() {
      @Override
      @NonNull
      public List<Appliance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPurchaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "purchaseDate");
          final int _cursorIndexOfWarrantyEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyEndDate");
          final int _cursorIndexOfModelNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "modelNumber");
          final int _cursorIndexOfSerialNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "serialNumber");
          final int _cursorIndexOfVendorName = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorName");
          final int _cursorIndexOfReceiptImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptImagePath");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Appliance> _result = new ArrayList<Appliance>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Appliance _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final long _tmpPurchaseDate;
            _tmpPurchaseDate = _cursor.getLong(_cursorIndexOfPurchaseDate);
            final long _tmpWarrantyEndDate;
            _tmpWarrantyEndDate = _cursor.getLong(_cursorIndexOfWarrantyEndDate);
            final String _tmpModelNumber;
            if (_cursor.isNull(_cursorIndexOfModelNumber)) {
              _tmpModelNumber = null;
            } else {
              _tmpModelNumber = _cursor.getString(_cursorIndexOfModelNumber);
            }
            final String _tmpSerialNumber;
            if (_cursor.isNull(_cursorIndexOfSerialNumber)) {
              _tmpSerialNumber = null;
            } else {
              _tmpSerialNumber = _cursor.getString(_cursorIndexOfSerialNumber);
            }
            final String _tmpVendorName;
            if (_cursor.isNull(_cursorIndexOfVendorName)) {
              _tmpVendorName = null;
            } else {
              _tmpVendorName = _cursor.getString(_cursorIndexOfVendorName);
            }
            final String _tmpReceiptImagePath;
            if (_cursor.isNull(_cursorIndexOfReceiptImagePath)) {
              _tmpReceiptImagePath = null;
            } else {
              _tmpReceiptImagePath = _cursor.getString(_cursorIndexOfReceiptImagePath);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new Appliance(_tmpId,_tmpName,_tmpCategory,_tmpPurchaseDate,_tmpWarrantyEndDate,_tmpModelNumber,_tmpSerialNumber,_tmpVendorName,_tmpReceiptImagePath,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Appliance>> getExpiredAppliances(final long currentDate) {
    final String _sql = "SELECT * FROM appliances WHERE warrantyEndDate < ? ORDER BY warrantyEndDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, currentDate);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"appliances"}, new Callable<List<Appliance>>() {
      @Override
      @NonNull
      public List<Appliance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPurchaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "purchaseDate");
          final int _cursorIndexOfWarrantyEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyEndDate");
          final int _cursorIndexOfModelNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "modelNumber");
          final int _cursorIndexOfSerialNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "serialNumber");
          final int _cursorIndexOfVendorName = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorName");
          final int _cursorIndexOfReceiptImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptImagePath");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Appliance> _result = new ArrayList<Appliance>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Appliance _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final long _tmpPurchaseDate;
            _tmpPurchaseDate = _cursor.getLong(_cursorIndexOfPurchaseDate);
            final long _tmpWarrantyEndDate;
            _tmpWarrantyEndDate = _cursor.getLong(_cursorIndexOfWarrantyEndDate);
            final String _tmpModelNumber;
            if (_cursor.isNull(_cursorIndexOfModelNumber)) {
              _tmpModelNumber = null;
            } else {
              _tmpModelNumber = _cursor.getString(_cursorIndexOfModelNumber);
            }
            final String _tmpSerialNumber;
            if (_cursor.isNull(_cursorIndexOfSerialNumber)) {
              _tmpSerialNumber = null;
            } else {
              _tmpSerialNumber = _cursor.getString(_cursorIndexOfSerialNumber);
            }
            final String _tmpVendorName;
            if (_cursor.isNull(_cursorIndexOfVendorName)) {
              _tmpVendorName = null;
            } else {
              _tmpVendorName = _cursor.getString(_cursorIndexOfVendorName);
            }
            final String _tmpReceiptImagePath;
            if (_cursor.isNull(_cursorIndexOfReceiptImagePath)) {
              _tmpReceiptImagePath = null;
            } else {
              _tmpReceiptImagePath = _cursor.getString(_cursorIndexOfReceiptImagePath);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new Appliance(_tmpId,_tmpName,_tmpCategory,_tmpPurchaseDate,_tmpWarrantyEndDate,_tmpModelNumber,_tmpSerialNumber,_tmpVendorName,_tmpReceiptImagePath,_tmpCreatedAt,_tmpUpdatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Appliance> getApplianceById(final long id) {
    final String _sql = "SELECT * FROM appliances WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"appliances"}, new Callable<Appliance>() {
      @Override
      @Nullable
      public Appliance call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfPurchaseDate = CursorUtil.getColumnIndexOrThrow(_cursor, "purchaseDate");
          final int _cursorIndexOfWarrantyEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "warrantyEndDate");
          final int _cursorIndexOfModelNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "modelNumber");
          final int _cursorIndexOfSerialNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "serialNumber");
          final int _cursorIndexOfVendorName = CursorUtil.getColumnIndexOrThrow(_cursor, "vendorName");
          final int _cursorIndexOfReceiptImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "receiptImagePath");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final Appliance _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final long _tmpPurchaseDate;
            _tmpPurchaseDate = _cursor.getLong(_cursorIndexOfPurchaseDate);
            final long _tmpWarrantyEndDate;
            _tmpWarrantyEndDate = _cursor.getLong(_cursorIndexOfWarrantyEndDate);
            final String _tmpModelNumber;
            if (_cursor.isNull(_cursorIndexOfModelNumber)) {
              _tmpModelNumber = null;
            } else {
              _tmpModelNumber = _cursor.getString(_cursorIndexOfModelNumber);
            }
            final String _tmpSerialNumber;
            if (_cursor.isNull(_cursorIndexOfSerialNumber)) {
              _tmpSerialNumber = null;
            } else {
              _tmpSerialNumber = _cursor.getString(_cursorIndexOfSerialNumber);
            }
            final String _tmpVendorName;
            if (_cursor.isNull(_cursorIndexOfVendorName)) {
              _tmpVendorName = null;
            } else {
              _tmpVendorName = _cursor.getString(_cursorIndexOfVendorName);
            }
            final String _tmpReceiptImagePath;
            if (_cursor.isNull(_cursorIndexOfReceiptImagePath)) {
              _tmpReceiptImagePath = null;
            } else {
              _tmpReceiptImagePath = _cursor.getString(_cursorIndexOfReceiptImagePath);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new Appliance(_tmpId,_tmpName,_tmpCategory,_tmpPurchaseDate,_tmpWarrantyEndDate,_tmpModelNumber,_tmpSerialNumber,_tmpVendorName,_tmpReceiptImagePath,_tmpCreatedAt,_tmpUpdatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
