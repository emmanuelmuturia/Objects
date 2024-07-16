package cifor.icraf.rest.feature.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestDTO(
    @SerialName("data")
    val restData: Data?,
    @SerialName("id")
    val restId: String,
    @SerialName("name")
    val restName: String
)