package cifor.icraf.objects.feature.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SubCountyEntity")
data class SubCountyEntity(
    @ColumnInfo(name = "subCountyId")
    @PrimaryKey
    val subCountyId: Int,
    @ColumnInfo(name = "subCountyName")
    val subCountyName: String
)