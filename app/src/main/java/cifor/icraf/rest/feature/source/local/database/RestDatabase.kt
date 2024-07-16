package cifor.icraf.rest.feature.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import cifor.icraf.rest.feature.source.local.dao.RestDao
import cifor.icraf.rest.feature.source.local.entity.RestEntity

@Database(entities = [RestEntity::class], version = 1, exportSchema = false)
abstract class RestDatabase : RoomDatabase() { abstract fun restDao() : RestDao }