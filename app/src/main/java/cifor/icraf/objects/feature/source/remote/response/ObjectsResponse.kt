package cifor.icraf.objects.feature.source.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ObjectsResponse(
    @SerialName("createdAt")
    val objectCreatedAt: String,
    @SerialName("id")
    val objectId: String,
    @SerialName("name")
    val objectName: String
)