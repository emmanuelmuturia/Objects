package cifor.icraf.objects.feature.data.models

data class County(
    val countyName: String,
    val id: Int,
    val subCounties: List<SubCounty>
)