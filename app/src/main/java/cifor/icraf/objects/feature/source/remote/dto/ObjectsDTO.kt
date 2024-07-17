package cifor.icraf.objects.feature.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ObjectsDTO(
    @SerialName("data")
    val objectData: Data?,
    @SerialName("id")
    val objectId: String,
    @SerialName("name")
    val objectName: String
)