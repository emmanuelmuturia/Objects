package cifor.icraf.objects.feature.source.remoteMock.model

import cifor.icraf.objects.feature.source.local.entities.CountyEntity
import cifor.icraf.objects.feature.source.remote.dto.SubCountyDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteMockCounty(
    @SerialName("county_name")
    val countyName: String,
    @SerialName("id")
    val countyId: Int,
    @SerialName("subCounties")
    val countySubCounties: List<RemoteMockSubCounty>
)

fun RemoteMockCounty.toCountyEntity(): CountyEntity = CountyEntity(
    countyId = countyId,
    countyName = countyName,
    countySubCounties = countySubCounties.map { it.toSubCountyEntity() }
)