package cifor.icraf.objects.feature.data.models

import cifor.icraf.objects.feature.source.local.room.entities.SubCountyEntity

data class SubCounty(
    val subCountyId: Int,
    val subCountyName: String
) {
    fun toSubCountyEntity(): SubCountyEntity {
        return SubCountyEntity(
            subCountyId = subCountyId,
            subCountyName = subCountyName
        )
    }
}