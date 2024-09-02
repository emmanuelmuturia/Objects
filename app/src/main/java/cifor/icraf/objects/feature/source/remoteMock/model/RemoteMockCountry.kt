package cifor.icraf.objects.feature.source.remoteMock.model

import cifor.icraf.objects.feature.source.local.entities.CountryEntity
import cifor.icraf.objects.feature.source.remote.dto.CountyDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMockCountry(
    @SerialName("code")
    val countryCode: String,
    @SerialName("counties")
    val countryCounties: List<RemoteMockCounty>,
    @SerialName("country_name")
    val countryName: String,
    @SerialName("currency")
    val countryCurrency: String,
    @SerialName("id")
    val countryId: Int,
    @SerialName("phoneCode")
    val countryPhoneCode: String
)

fun RemoteMockCountry.toCountryEntity(): CountryEntity = CountryEntity(
    countryId = countryId,
    countryName = countryName,
    countryCurrency = countryCurrency,
    countryCode = countryCode,
    countryCounties = countryCounties.map { it.toCountyEntity() },
    countryPhoneCode = countryPhoneCode
)