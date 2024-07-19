package cifor.icraf.objects.feature.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ResponseObject(
    val objectId: String? = null,
    val objectName: String? = null,
    val objectCreatedAt: String? = null
)