package cifor.icraf.objects.feature.source.mock.model

data class MockCounty(
    val countyName: String,
    val countyId: Int,
    val countySubCounties: List<MockSubCounty>
)