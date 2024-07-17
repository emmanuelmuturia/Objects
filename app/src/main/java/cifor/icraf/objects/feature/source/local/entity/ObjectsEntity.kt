package cifor.icraf.objects.feature.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ObjectsEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val objectId: String,
    @ColumnInfo(name = "name")
    val objectName: String
)