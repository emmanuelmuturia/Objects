package cifor.icraf.objects.feature.source.remoteMock.model

import cifor.icraf.objects.feature.source.local.entities.SubCountyEntity
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMockSubCounty(
    val subCountyId: Int,
    val subCountyName: String
)

fun RemoteMockSubCounty.toSubCountyEntity(): SubCountyEntity = SubCountyEntity(
    subCountyId = subCountyId,
    subCountyName = subCountyName
)