package cifor.icraf.objects.feature.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import cifor.icraf.objects.feature.source.local.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.entity.ObjectsEntity

@Database(entities = [ObjectsEntity::class], version = 1, exportSchema = false)
abstract class ObjectsDatabase : RoomDatabase() { abstract fun objectsDao() : ObjectsDao }