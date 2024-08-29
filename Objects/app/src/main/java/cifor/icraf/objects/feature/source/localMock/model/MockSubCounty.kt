package cifor.icraf.objects.feature.source.localMock.model

import kotlinx.serialization.Serializable

@Serializable
data class MockSubCounty(
    val subCountyId: Int,
    val subCountyName: String
)