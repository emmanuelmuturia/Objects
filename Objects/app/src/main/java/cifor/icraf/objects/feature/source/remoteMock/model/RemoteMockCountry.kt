package cifor.icraf.objects.feature.source.remoteMock.model

import cifor.icraf.objects.feature.source.localMock.model.LocalMockCounty
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