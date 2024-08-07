package cifor.icraf.objects.feature.source.remote.dto


import cifor.icraf.objects.feature.source.local.room.entities.CountyEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountyDTO(
    @SerialName("county_name")
    val countyName: String,
    @SerialName("id")
    val countyId: Int,
    @SerialName("subCounties")
    val countySubCounties: List<SubCountyDTO>
) {
    fun toCountyEntity(): CountyEntity {
        return CountyEntity(
            countyId = countyId,
            countyName = countyName,
            countySubCounties = countySubCounties.map { it.toSubCountyEntity() }
        )
    }
}