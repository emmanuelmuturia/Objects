package cifor.icraf.objects.feature.source.localMock.model

import kotlinx.serialization.Serializable

@Serializable
data class LocalMockSubCounty(
    val subCountyId: Int,
    val subCountyName: String
)