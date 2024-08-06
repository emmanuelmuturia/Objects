package cifor.icraf.objects.feature.source.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import cifor.icraf.objects.feature.source.remote.dto.SubCounty

@Entity(tableName = "CountyEntity")
data class CountyEntity(
    @ColumnInfo(name = "countyName")
    val countyName: String,
    @ColumnInfo(name = "countyId")
    val countyId: Int,
    @ColumnInfo(name = "countySubCounties")
    val countySubCounties: List<SubCounty>
)