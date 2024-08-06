package cifor.icraf.objects.feature.source.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.EntityUpsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import cifor.icraf.objects.feature.source.local.entities.ObjectsEntity;
import cifor.icraf.objects.feature.source.local.entities.ObjectsResponseEntity;
import java.lang.Class;
import java.lang.Exception;
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
public final class ObjectsDao_Impl implements ObjectsDao {
  private final RoomDatabase __db;

  private final EntityUpsertionAdapter<ObjectsEntity> __upsertionAdapterOfObjectsEntity;

  private final EntityUpsertionAdapter<ObjectsResponseEntity> __upsertionAdapterOfObjectsResponseEntity;

  public ObjectsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__upsertionAdapterOfObjectsEntity = new EntityUpsertionAdapter<ObjectsEntity>(new EntityInsertionAdapter<ObjectsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `ObjectsEntity` (`id`,`name`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ObjectsEntity entity) {
        statement.bindString(1, entity.getObjectId());
        statement.bindString(2, entity.getObjectName());
      }
    }, new EntityDeletionOrUpdateAdapter<ObjectsEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `ObjectsEntity` SET `id` = ?,`name` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ObjectsEntity entity) {
        statement.bindString(1, entity.getObjectId());
        statement.bindString(2, entity.getObjectName());
        statement.bindString(3, entity.getObjectId());
      }
    });
    this.__upsertionAdapterOfObjectsResponseEntity = new EntityUpsertionAdapter<ObjectsResponseEntity>(new EntityInsertionAdapter<ObjectsResponseEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `ObjectsResponseEntity` (`id`,`name`,`objectCreatedAt`) VALUES (?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ObjectsResponseEntity entity) {
        statement.bindString(1, entity.getObjectId());
        statement.bindString(2, entity.getObjectName());
        statement.bindString(3, entity.getObjectCreatedAt());
      }
    }, new EntityDeletionOrUpdateAdapter<ObjectsResponseEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `ObjectsResponseEntity` SET `id` = ?,`name` = ?,`objectCreatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ObjectsResponseEntity entity) {
        statement.bindString(1, entity.getObjectId());
        statement.bindString(2, entity.getObjectName());
        statement.bindString(3, entity.getObjectCreatedAt());
        statement.bindString(4, entity.getObjectId());
      }
    });
  }

  @Override
  public Object upsertObjectEntity(final ObjectsEntity objectsEntity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfObjectsEntity.upsert(objectsEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object upsertObjectsResponseEntity(final ObjectsResponseEntity objectsResponseEntity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfObjectsResponseEntity.upsert(objectsResponseEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ObjectsEntity>> getAllObjects() {
    final String _sql = "SELECT * FROM ObjectsEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ObjectsEntity"}, new Callable<List<ObjectsEntity>>() {
      @Override
      @NonNull
      public List<ObjectsEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfObjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfObjectName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final List<ObjectsEntity> _result = new ArrayList<ObjectsEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ObjectsEntity _item;
            final String _tmpObjectId;
            _tmpObjectId = _cursor.getString(_cursorIndexOfObjectId);
            final String _tmpObjectName;
            _tmpObjectName = _cursor.getString(_cursorIndexOfObjectName);
            _item = new ObjectsEntity(_tmpObjectId,_tmpObjectName);
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
  public Flow<ObjectsResponseEntity> getAllResponseObjects() {
    final String _sql = "SELECT * FROM ObjectsResponseEntity";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"ObjectsResponseEntity"}, new Callable<ObjectsResponseEntity>() {
      @Override
      @NonNull
      public ObjectsResponseEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfObjectId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfObjectName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfObjectCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "objectCreatedAt");
          final ObjectsResponseEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpObjectId;
            _tmpObjectId = _cursor.getString(_cursorIndexOfObjectId);
            final String _tmpObjectName;
            _tmpObjectName = _cursor.getString(_cursorIndexOfObjectName);
            final String _tmpObjectCreatedAt;
            _tmpObjectCreatedAt = _cursor.getString(_cursorIndexOfObjectCreatedAt);
            _result = new ObjectsResponseEntity(_tmpObjectId,_tmpObjectName,_tmpObjectCreatedAt);
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
