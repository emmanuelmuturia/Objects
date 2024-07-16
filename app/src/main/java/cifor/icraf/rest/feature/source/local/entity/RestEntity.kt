package cifor.icraf.rest.feature.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RestEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val restId: String,
    @ColumnInfo(name = "name")
    val restName: String
)