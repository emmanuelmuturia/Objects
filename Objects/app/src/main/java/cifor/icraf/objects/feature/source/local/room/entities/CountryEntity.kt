package cifor.icraf.objects.feature.source.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import cifor.icraf.objects.feature.source.remote.dto.County

@Entity(tableName = "CountryEntity")
data class CountryEntity(
    @ColumnInfo(name = "countryCode")
    val countryCode: String,
    @ColumnInfo(name = "countryCounties")
    val countryCounties: List<County>,
    @ColumnInfo(name = "countryName")
    val countryName: String,
    @ColumnInfo(name = "countryCurrency")
    val countryCurrency: String,
    @ColumnInfo(name = "countryId")
    val countryId: Int,
    @ColumnInfo(name = "countryPhoneCode")
    val countryPhoneCode: String
)