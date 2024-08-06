package cifor.icraf.objects.feature.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import cifor.icraf.objects.feature.source.local.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.entities.ObjectsEntity
import cifor.icraf.objects.feature.source.local.entities.ObjectsResponseEntity

@Database(entities = [ObjectsEntity::class, ObjectsResponseEntity::class], version = 1, exportSchema = false)
abstract class ObjectsDatabase : RoomDatabase() { abstract fun objectsDao() : ObjectsDao }