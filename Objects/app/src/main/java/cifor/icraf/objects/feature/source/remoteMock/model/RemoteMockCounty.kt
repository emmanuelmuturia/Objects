package cifor.icraf.objects.feature.source.remoteMock.model

import cifor.icraf.objects.feature.source.localMock.model.LocalMockSubCounty
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMockCounty(
    val countyName: String,
    val countyId: Int,
    val countySubCounties: List<RemoteMockSubCounty>
)