package cifor.icraf.objects.feature.source.localMock.model

import kotlinx.serialization.Serializable

@Serializable
data class MockCountry(
    val countryCode: String,
    val countryCounties: List<MockCounty>,
    val countryName: String,
    val countryCurrency: String,
    val countryId: Int,
    val countryPhoneCode: String
)