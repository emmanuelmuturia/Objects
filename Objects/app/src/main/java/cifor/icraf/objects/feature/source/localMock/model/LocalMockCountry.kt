package cifor.icraf.objects.feature.source.localMock.model

import kotlinx.serialization.Serializable

@Serializable
data class LocalMockCountry(
    val countryCode: String,
    val countryCounties: List<LocalMockCounty>,
    val countryName: String,
    val countryCurrency: String,
    val countryId: Int,
    val countryPhoneCode: String
)