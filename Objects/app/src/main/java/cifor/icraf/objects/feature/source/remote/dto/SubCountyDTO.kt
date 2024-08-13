package cifor.icraf.objects.feature.source.remote.dto


import cifor.icraf.objects.feature.source.local.entities.SubCountyEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubCountyDTO(
    @SerialName("id")
    val subCountyId: Int,
    @SerialName("subcounty_name")
    val subCountyName: String
) {
    fun toSubCountyEntity(): SubCountyEntity {
        return SubCountyEntity(
            subCountyId = subCountyId,
            subCountyName = subCountyName
        )
    }
}
