package cifor.icraf.objects.feature.source.remoteMock.model

import cifor.icraf.objects.feature.source.local.entities.CountyEntity
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMockCounty(
    val countyName: String,
    val countyId: Int,
    val countySubCounties: List<RemoteMockSubCounty>
)

fun RemoteMockCounty.toCountyEntity(): CountyEntity = CountyEntity(
    countyId = countyId,
    countyName = countyName,
    countySubCounties = countySubCounties.map { it.toSubCountyEntity() }
)