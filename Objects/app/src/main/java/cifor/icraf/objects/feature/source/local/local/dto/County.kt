package cifor.icraf.objects.feature.source.local.local.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class County(
    @SerialName("county_name")
    val countyName: String,
    @SerialName("id")
    val id: Int,
    @SerialName("subCounties")
    val subCounties: List<SubCounty>
)