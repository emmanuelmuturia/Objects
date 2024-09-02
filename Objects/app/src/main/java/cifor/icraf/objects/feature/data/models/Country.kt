package cifor.icraf.objects.feature.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val countryCode: String,
    val countryCounties: List<County>,
    val countryName: String,
    val countryCurrency: String,
    val countryId: Int,
    val countryPhoneCode: String
)