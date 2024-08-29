package cifor.icraf.objects.feature.source.remoteMock.model

import kotlinx.serialization.Serializable

@Serializable
data class RemoteMockSubCounty(
    val subCountyId: Int,
    val subCountyName: String
)