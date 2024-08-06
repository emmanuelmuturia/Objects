package cifor.icraf.objects.feature.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryDTO(
    @SerialName("code")
    val countryCode: String,
    @SerialName("counties")
    val countryCounties: List<County>,
    @SerialName("country_name")
    val countryName: String,
    @SerialName("currency")
    val countryCurrency: String,
    @SerialName("id")
    val countryId: Int,
    @SerialName("phoneCode")
    val countryPhoneCode: String
)