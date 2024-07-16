package cifor.icraf.rest.feature.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("CPU model")
    val cpuModel: String?,
    @SerialName("capacity")
    val capacity: String?,
    @SerialName("Capacity")
    val theCapacity: String?,
    @SerialName("capacity GB")
    val capacityGB: Int?,
    @SerialName("Case Size")
    val caseSize: String?,
    @SerialName("color")
    val color: String?,
    @SerialName("Color")
    val theColor: String?,
    @SerialName("Description")
    val description: String?,
    @SerialName("generation")
    val generation: String?,
    @SerialName("Generation")
    val theGeneration: String?,
    @SerialName("Hard disk size")
    val hardDiskSize: String?,
    @SerialName("price")
    val price: Double?,
    @SerialName("Price")
    val thePrice: String?,
    @SerialName("Screen size")
    val screenSize: Double?,
    @SerialName("Strap Colour")
    val strapColour: String?,
    @SerialName("year")
    val year: Int?
)