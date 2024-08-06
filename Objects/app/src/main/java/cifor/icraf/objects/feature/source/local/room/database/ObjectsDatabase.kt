package cifor.icraf.objects.feature.source.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import cifor.icraf.objects.feature.source.local.room.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.room.entities.CountryEntity
import cifor.icraf.objects.feature.source.local.room.entities.CountyEntity
import cifor.icraf.objects.feature.source.local.room.entities.SubCountyEntity

@Database(entities = [CountryEntity::class, CountyEntity::class, SubCountyEntity::class], version = 1, exportSchema = false)
abstract class ObjectsDatabase : RoomDatabase() { abstract fun objectsDao() : ObjectsDao }