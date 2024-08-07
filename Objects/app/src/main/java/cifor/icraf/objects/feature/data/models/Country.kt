package cifor.icraf.objects.feature.data.models


data class Country(
    val countryCode: String,
    val countryCounties: List<County>,
    val countryName: String,
    val countryCurrency: String,
    val countryId: Int,
    val countryPhoneCode: String
)