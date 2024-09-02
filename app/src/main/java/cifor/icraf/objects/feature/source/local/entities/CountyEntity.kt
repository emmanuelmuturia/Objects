package cifor.icraf.objects.feature.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "CountyEntity")
@Serializable
data class CountyEntity(
    @ColumnInfo(name = "countyName")
    val countyName: String,
    @ColumnInfo(name = "countyId")
    @PrimaryKey
    val countyId: Int,
    @ColumnInfo(name = "countySubCounties")
    val countySubCounties: List<SubCountyEntity>
)