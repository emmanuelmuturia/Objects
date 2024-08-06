package cifor.icraf.objects.feature.source.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "SubCountyEntity")
data class SubCountyEntity(
    @ColumnInfo(name = "subCountyId")
    val subCountyId: Int,
    @ColumnInfo(name = "subCountyName")
    val subCountyName: String
)