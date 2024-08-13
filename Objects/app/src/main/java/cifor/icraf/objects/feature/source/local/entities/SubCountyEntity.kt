package cifor.icraf.objects.feature.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "SubCountyEntity")
@Serializable
data class SubCountyEntity(
    @ColumnInfo(name = "subCountyId")
    @PrimaryKey
    val subCountyId: Int,
    @ColumnInfo(name = "subCountyName")
    val subCountyName: String
)