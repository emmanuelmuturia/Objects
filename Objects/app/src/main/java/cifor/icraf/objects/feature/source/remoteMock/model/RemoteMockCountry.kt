package cifor.icraf.objects.feature.source.remoteMock.model

import cifor.icraf.objects.feature.source.local.entities.CountryEntity
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMockCountry(
    val countryCode: String,
    val countryCounties: List<RemoteMockCounty>,
    val countryName: String,
    val countryCurrency: String,
    val countryId: Int,
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