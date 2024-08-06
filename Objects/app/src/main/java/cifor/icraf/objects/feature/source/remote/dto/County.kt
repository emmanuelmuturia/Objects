package cifor.icraf.objects.feature.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class County(
    @SerialName("county_name")
    val countyName: String,
    @SerialName("id")
    val countyId: Int,
    @SerialName("subCounties")
    val countySubCounties: List<SubCounty>
)