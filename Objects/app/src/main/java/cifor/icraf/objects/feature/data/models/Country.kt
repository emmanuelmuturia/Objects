package cifor.icraf.objects.feature.data.models


data class Country(
    val code: String,
    val counties: List<County>,
    val countryName: String,
    val currency: String,
    val id: Int,
    val phoneCode: String
)