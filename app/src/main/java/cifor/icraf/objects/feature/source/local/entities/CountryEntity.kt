package cifor.icraf.objects.feature.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "CountryEntity")
@Serializable
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
    @PrimaryKey
    val countryId: Int,
    @ColumnInfo(name = "countryPhoneCode")
    val countryPhoneCode: String
)