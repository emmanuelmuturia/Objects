package cifor.icraf.objects.feature.source.localMock.model

import kotlinx.serialization.Serializable

@Serializable
data class MockCounty(
    val countyName: String,
    val countyId: Int,
    val countySubCounties: List<MockSubCounty>
)