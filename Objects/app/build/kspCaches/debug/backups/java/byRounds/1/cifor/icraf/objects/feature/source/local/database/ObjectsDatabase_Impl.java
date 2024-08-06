package cifor.icraf.objects.feature.source.local.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import cifor.icraf.objects.feature.source.local.dao.ObjectsDao;
import cifor.icraf.objects.feature.source.local.dao.ObjectsDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ObjectsDatabase_Impl extends ObjectsDatabase {
  private volatile ObjectsDao _objectsDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `ObjectsEntity` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `ObjectsResponseEntity` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `objectCreatedAt` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'dcfbe3e76272b7e964f3a7bbaefa1d8d')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `ObjectsEntity`");
        db.execSQL("DROP TABLE IF EXISTS `ObjectsResponseEntity`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsObjectsEntity = new HashMap<String, TableInfo.Column>(2);
        _columnsObjectsEntity.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsObjectsEntity.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysObjectsEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesObjectsEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoObjectsEntity = new TableInfo("ObjectsEntity", _columnsObjectsEntity, _foreignKeysObjectsEntity, _indicesObjectsEntity);
        final TableInfo _existingObjectsEntity = TableInfo.read(db, "ObjectsEntity");
        if (!_infoObjectsEntity.equals(_existingObjectsEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "ObjectsEntity(cifor.icraf.objects.feature.source.local.entities.ObjectsEntity).\n"
                  + " Expected:\n" + _infoObjectsEntity + "\n"
                  + " Found:\n" + _existingObjectsEntity);
        }
        final HashMap<String, TableInfo.Column> _columnsObjectsResponseEntity = new HashMap<String, TableInfo.Column>(3);
        _columnsObjectsResponseEntity.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsObjectsResponseEntity.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsObjectsResponseEntity.put("objectCreatedAt", new TableInfo.Column("objectCreatedAt", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysObjectsResponseEntity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesObjectsResponseEntity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoObjectsResponseEntity = new TableInfo("ObjectsResponseEntity", _columnsObjectsResponseEntity, _foreignKeysObjectsResponseEntity, _indicesObjectsResponseEntity);
        final TableInfo _existingObjectsResponseEntity = TableInfo.read(db, "ObjectsResponseEntity");
        if (!_infoObjectsResponseEntity.equals(_existingObjectsResponseEntity)) {
          return new RoomOpenHelper.ValidationResult(false, "ObjectsResponseEntity(cifor.icraf.objects.feature.source.local.entities.ObjectsResponseEntity).\n"
                  + " Expected:\n" + _infoObjectsResponseEntity + "\n"
                  + " Found:\n" + _existingObjectsResponseEntity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "dcfbe3e76272b7e964f3a7bbaefa1d8d", "56573eaf4344bec249ab9d5ae7a66a91");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "ObjectsEntity","ObjectsResponseEntity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `ObjectsEntity`");
      _db.execSQL("DELETE FROM `ObjectsResponseEntity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ObjectsDao.class, ObjectsDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ObjectsDao objectsDao() {
    if (_objectsDao != null) {
      return _objectsDao;
    } else {
      synchronized(this) {
        if(_objectsDao == null) {
          _objectsDao = new ObjectsDao_Impl(this);
        }
        return _objectsDao;
      }
    }
  }
}
