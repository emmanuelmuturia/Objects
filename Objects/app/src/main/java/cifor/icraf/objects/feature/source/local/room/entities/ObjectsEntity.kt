package cifor.icraf.objects.feature.source.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import cifor.icraf.objects.feature.source.remote.dto.ObjectsDTO
import kotlinx.serialization.Serializable

@Entity(tableName = "ObjectsEntity")
@Serializable
data class ObjectsEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey
    val objectId: String,
    @ColumnInfo(name = "name")
    val objectName: String
) {
    fun toDTO(): ObjectsDTO {
        return ObjectsDTO(
            objectId = objectId,
            objectName = objectName
        )
    }
}