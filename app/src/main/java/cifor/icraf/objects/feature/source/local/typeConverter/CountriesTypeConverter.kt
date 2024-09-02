package cifor.icraf.objects.feature.source.local.typeConverter

import androidx.room.TypeConverter
import cifor.icraf.objects.feature.source.local.entities.CountyEntity
import cifor.icraf.objects.feature.source.local.entities.SubCountyEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CountriesTypeConverter {

    @TypeConverter
    fun fromListOfCountyEntities(countyEntities: List<CountyEntity>): String {
        return Json.encodeToString(value = countyEntities)
    }

    @TypeConverter
    fun toListOfCountyEntities(countyEntities: String): List<CountyEntity> {
        return Json.decodeFromString(string = countyEntities)
    }

    @TypeConverter
    fun fromListOfSubCountyEntities(subCountyEntities: List<SubCountyEntity>): String {
        return Json.encodeToString(value = subCountyEntities)
    }

    @TypeConverter
    fun toListOfSubCountyEntities(subCountyEntities: String): List<SubCountyEntity> {
        return Json.decodeFromString(string = subCountyEntities)
    }

}