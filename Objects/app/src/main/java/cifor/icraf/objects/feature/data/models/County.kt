package cifor.icraf.objects.feature.data.models

import cifor.icraf.objects.feature.source.local.room.entities.CountyEntity

data class County(
    val countyName: String,
    val countyId: Int,
    val countySubCounties: List<SubCounty>
) {
    fun toCountyEntity(): CountyEntity {
        return CountyEntity(
            countyId = countyId,
            countyName = countyName,
            countySubCounties = countySubCounties.map { it.toSubCountyEntity() }
        )
    }
}