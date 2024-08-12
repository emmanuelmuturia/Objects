package cifor.icraf.objects.feature.source.mock.source

import cifor.icraf.objects.feature.source.mock.model.MockCountry
import cifor.icraf.objects.feature.source.mock.model.MockCounty
import cifor.icraf.objects.feature.source.mock.model.MockSubCounty
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MockSourceImplementation(
    private val ioDispatcher: CoroutineDispatcher
) : MockSource {

    private val mockCountries = listOf(
        MockCountry(
            countryCode = "KE",
            countryCounties = listOf(
                MockCounty(
                    countyName = "County #1",
                    countyId = 1,
                    countySubCounties = listOf(
                        MockSubCounty(
                            subCountyId = 1,
                            subCountyName = "SubCounty #1"
                        )
                    ),
                )
            ),
            countryName = "Country #1",
            countryCurrency = "KES",
            countryId = 1,
            countryPhoneCode = "+254"
        ),
        MockCountry(
            countryCode = "KE",
            countryCounties = listOf(
                MockCounty(
                    countyName = "County #1",
                    countyId = 1,
                    countySubCounties = listOf(
                        MockSubCounty(
                            subCountyId = 1,
                            subCountyName = "SubCounty #1"
                        )
                    ),
                )
            ),
            countryName = "Country #1",
            countryCurrency = "KES",
            countryId = 1,
            countryPhoneCode = "+254"
        ),
        MockCountry(
            countryCode = "KE",
            countryCounties = listOf(
                MockCounty(
                    countyName = "County #1",
                    countyId = 1,
                    countySubCounties = listOf(
                        MockSubCounty(
                            subCountyId = 1,
                            subCountyName = "SubCounty #1"
                        )
                    ),
                )
            ),
            countryName = "Country #1",
            countryCurrency = "KES",
            countryId = 1,
            countryPhoneCode = "+254"
        ),
        MockCountry(
            countryCode = "KE",
            countryCounties = listOf(
                MockCounty(
                    countyName = "County #1",
                    countyId = 1,
                    countySubCounties = listOf(
                        MockSubCounty(
                            subCountyId = 1,
                            subCountyName = "SubCounty #1"
                        )
                    ),
                )
            ),
            countryName = "Country #1",
            countryCurrency = "KES",
            countryId = 1,
            countryPhoneCode = "+254"
        ),
        MockCountry(
            countryCode = "KE",
            countryCounties = listOf(
                MockCounty(
                    countyName = "County #1",
                    countyId = 1,
                    countySubCounties = listOf(
                        MockSubCounty(
                            subCountyId = 1,
                            subCountyName = "SubCounty #1"
                        )
                    ),
                )
            ),
            countryName = "Country #1",
            countryCurrency = "KES",
            countryId = 1,
            countryPhoneCode = "+254"
        ),
        MockCountry(
            countryCode = "KE",
            countryCounties = listOf(
                MockCounty(
                    countyName = "County #1",
                    countyId = 1,
                    countySubCounties = listOf(
                        MockSubCounty(
                            subCountyId = 1,
                            subCountyName = "SubCounty #1"
                        )
                    ),
                )
            ),
            countryName = "Country #1",
            countryCurrency = "KES",
            countryId = 1,
            countryPhoneCode = "+254"
        ),
        MockCountry(
            countryCode = "KE",
            countryCounties = listOf(
                MockCounty(
                    countyName = "County #1",
                    countyId = 1,
                    countySubCounties = listOf(
                        MockSubCounty(
                            subCountyId = 1,
                            subCountyName = "SubCounty #1"
                        )
                    ),
                )
            ),
            countryName = "Country #1",
            countryCurrency = "KES",
            countryId = 1,
            countryPhoneCode = "+254"
        ),
    )

    override suspend fun getAllMockCountries(): Flow<List<MockCountry>> = flow {
        emit(value = mockCountries)
    }.flowOn(context = ioDispatcher)

}