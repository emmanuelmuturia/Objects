package cifor.icraf.objects.feature.source.local.local.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("code")
    val code: String,
    @SerialName("counties")
    val counties: List<County>,
    @SerialName("country_name")
    val countryName: String,
    @SerialName("currency")
    val currency: String,
    @SerialName("id")
    val id: Int,
    @SerialName("phoneCode")
    val phoneCode: String
)