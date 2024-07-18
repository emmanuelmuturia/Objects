package cifor.icraf.objects.feature.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ObjectsResponseEntity")
data class ObjectsResponseEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val objectId: String,
    @ColumnInfo(name = "name")
    val objectName: String,
    @ColumnInfo(name = "objectCreatedAt")
    val objectCreatedAt: String
)