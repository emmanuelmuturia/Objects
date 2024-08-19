package cifor.icraf.objects.feature.data.models

import cifor.icraf.objects.feature.source.local.entities.SubCountyEntity
import cifor.icraf.objects.feature.source.mock.model.MockSubCounty
import kotlinx.serialization.Serializable

@Serializable
data class SubCounty(
    val subCountyId: Int,
    val subCountyName: String
)

fun SubCountyEntity.toSubCounty(): SubCounty {
    return SubCounty(
        subCountyId = this.subCountyId,
        subCountyName = this.subCountyName
    )
}

fun SubCounty.toSubCountyEntity(): SubCountyEntity {
    return SubCountyEntity(
        subCountyId = this.subCountyId,
        subCountyName = this.subCountyName
    )
}

fun MockSubCounty.toSubCounty(): SubCounty {
    return SubCounty(
        subCountyId = this.subCountyId,
        subCountyName = this.subCountyName
    )
}