package cifor.icraf.objects.feature.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ResponseObject(
    val objectId: String = "",
    val objectName: String = "",
    val objectCreatedAt: String = ""
)