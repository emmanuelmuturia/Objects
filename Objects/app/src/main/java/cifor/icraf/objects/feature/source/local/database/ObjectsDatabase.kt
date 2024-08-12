package cifor.icraf.objects.feature.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import cifor.icraf.objects.feature.source.local.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.entities.CountryEntity
import cifor.icraf.objects.feature.source.local.entities.CountyEntity
import cifor.icraf.objects.feature.source.local.entities.SubCountyEntity
import cifor.icraf.objects.feature.source.local.typeConverter.CountriesTypeConverter

@Database(
    entities = [CountryEntity::class, CountyEntity::class, SubCountyEntity::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(value = [CountriesTypeConverter::class])
abstract class ObjectsDatabase : RoomDatabase() {
    abstract fun objectsDao(): ObjectsDao
}