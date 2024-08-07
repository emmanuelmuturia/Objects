package cifor.icraf.objects.feature.source.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CountyEntity")
data class CountyEntity(
    @ColumnInfo(name = "countyName")
    val countyName: String,
    @ColumnInfo(name = "countyId")
    @PrimaryKey
    val countyId: Int,
    @ColumnInfo(name = "countySubCounties")
    val countySubCounties: List<SubCountyEntity>
)