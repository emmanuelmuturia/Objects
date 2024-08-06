package cifor.icraf.objects.feature.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubCounty(
    @SerialName("id")
    val subCountyId: Int,
    @SerialName("subcounty_name")
    val subCountyName: String
)