package cifor.icraf.objects.feature.source.remote.dto


import cifor.icraf.objects.feature.source.local.entities.CountryEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryDTO(
    @SerialName("code")
    val countryCode: String,
    @SerialName("counties")
    val countryCounties: List<CountyDTO>,
    @SerialName("country_name")
    val countryName: String,
    @SerialName("currency")
    val countryCurrency: String,
    @SerialName("id")
    val countryId: Int,
    @SerialName("phoneCode")
    val countryPhoneCode: String
) {
    fun toCountryEntity(): CountryEntity {
        return CountryEntity(
            countryId = countryId,
            countryName = countryName,
            countryCurrency = countryCurrency,
            countryCode = countryCode,
            countryCounties = countryCounties.map { it.toCountyEntity() },
            countryPhoneCode = countryPhoneCode
        )
    }
}
