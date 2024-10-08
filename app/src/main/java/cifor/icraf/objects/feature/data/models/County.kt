package cifor.icraf.objects.feature.data.models

import cifor.icraf.objects.feature.source.local.entities.CountyEntity
import cifor.icraf.objects.feature.source.localMock.model.LocalMockCounty
import kotlinx.serialization.Serializable

@Serializable
data class County(
    val countyName: String,
    val countyId: Int,
    val countySubCounties: List<SubCounty>
)

fun CountyEntity.toCounty(): County {
    return County(
        countyId = this.countyId,
        countyName = this.countyName,
        countySubCounties = this.countySubCounties.map { it.toSubCounty() }
    )
}

fun County.toCountyEntity(): CountyEntity {
    return CountyEntity(
        countyId = this.countyId,
        countyName = this.countyName,
        countySubCounties = this.countySubCounties.map { it.toSubCountyEntity() }
    )
}

fun LocalMockCounty.toCounty(): County {
    return County(
        countyName = this.countyName,
        countyId = this.countyId,
        countySubCounties = this.countySubCounties.map { it.toSubCounty() }
    )
}