package cifor.icraf.objects.feature.source.remote.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ObjectsResponse(
    @SerialName("createdAt")
    val objectCreatedAt: String? = null,
    @SerialName("data")
    val objectData: DataResponse? = null,
    @SerialName("id")
    val objectId: String? = null,
    @SerialName("name")
    val objectName: String? = null
)