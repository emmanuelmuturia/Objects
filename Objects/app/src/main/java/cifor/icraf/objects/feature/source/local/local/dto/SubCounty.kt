package cifor.icraf.objects.feature.source.local.local.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubCounty(
    @SerialName("id")
    val id: Int,
    @SerialName("subcounty_name")
    val subcountyName: String
)