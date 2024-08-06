package cifor.icraf.objects.feature.source.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("CPU model")
    val cPUModel: String? = null,
    @SerialName("capacity")
    val capacity: String? = null,
    @SerialName("Capacity")
    val theCapacity: String? = null,
    @SerialName("capacity GB")
    val capacityGB: Int? = null,
    @SerialName("Case Size")
    val caseSize: String? = null,
    @SerialName("color")
    val color: String? = null,
    @SerialName("Color")
    val theColor: String? = null,
    @SerialName("Description")
    val description: String? = null,
    @SerialName("generation")
    val generation: String? = null,
    @SerialName("Generation")
    val theGeneration: String? = null,
    @SerialName("Hard disk size")
    val hardDiskSize: String? = null,
    @SerialName("price")
    val price: Double? = null,
    @SerialName("Price")
    val thePrice: String? = null,
    @SerialName("Screen size")
    val screenSize: Double? = null,
    @SerialName("Strap Colour")
    val strapColour: String? = null,
    @SerialName("year")
    val year: Int? = null
)