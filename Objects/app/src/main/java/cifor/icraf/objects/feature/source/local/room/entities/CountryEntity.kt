package cifor.icraf.objects.feature.source.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "CountryEntity")
data class CountryEntity(
    @ColumnInfo(name = "countryCode")
    val countryCode: String,
    @ColumnInfo(name = "countryCounties")
    val countryCounties: List<CountyEntity>,
    @ColumnInfo(name = "countryName")
    val countryName: String,
    @ColumnInfo(name = "countryCurrency")
    val countryCurrency: String,
    @ColumnInfo(name = "countryId")
    val countryId: Int,
    @ColumnInfo(name = "countryPhoneCode")
    val countryPhoneCode: String
)