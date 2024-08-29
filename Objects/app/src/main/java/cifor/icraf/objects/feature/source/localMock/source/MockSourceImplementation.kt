package cifor.icraf.objects.feature.source.localMock.source

import cifor.icraf.objects.feature.source.localMock.model.MockCountry
import cifor.icraf.objects.feature.source.localMock.model.MockCounty
import cifor.icraf.objects.feature.source.localMock.model.MockSubCounty
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MockSourceImplementation(
    private val ioDispatcher: CoroutineDispatcher
) : MockSource {

    private val mockCountries = Json.encodeToString(value = listOf(
        MockCountry(
            countryCode = "Country Code #1",
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
            countryCurrency = "Country Currency #1",
            countryId = 1,
            countryPhoneCode = "Country Phone Code #1"
        ),
        MockCountry(
            countryCode = "Country Code #2",
            countryCounties = listOf(
                MockCounty(
                    countyName = "County #2",
                    countyId = 2,
                    countySubCounties = listOf(
                        MockSubCounty(
                            subCountyId = 2,
                            subCountyName = "SubCounty #2"
                        )
                    ),
                )
            ),
            countryName = "Country #2",
            countryCurrency = "Country Currency #2",
            countryId = 2,
            countryPhoneCode = "Country Phone Code #2"
        ),
        MockCountry(
            countryCode = "Country Code #3",
            countryCounties = listOf(
                MockCounty(
                    countyName = "County #3",
                    countyId = 3,
                    countySubCounties = listOf(
                        MockSubCounty(
                            subCountyId = 3,
                            subCountyName = "SubCounty #3"
                        ),
                    )
                ),
            ),
            countryName = "Country #3",
            countryCurrency = "Country Currency #3",
            countryId = 3,
            countryPhoneCode = "Country Phone Code #3"
        ),
        MockCountry(
            countryCode = "Country Code #4",
            countryCounties = listOf(
                MockCounty(
                    countyName = "County #4",
                    countyId = 4,
                    countySubCounties = listOf(
                        MockSubCounty(
                            subCountyId = 4,
                            subCountyName = "SubCounty #4"
                        )
                    ),
                )
            ),
            countryName = "Country #4",
            countryCurrency = "Country Currency #4",
            countryId = 4,
            countryPhoneCode = "Country Phone Code #4"
        ),
        MockCountry(
            countryCode = "Country Code #5",
            countryCounties = listOf(
                MockCounty(
                    countyName = "County #5",
                    countyId = 5,
                    countySubCounties = listOf(
                        MockSubCounty(
                            subCountyId = 5,
                            subCountyName = "SubCounty #5"
                        )
                    ),
                )
            ),
            countryName = "Country #5",
            countryCurrency = "Country Currency #5",
            countryId = 5,
            countryPhoneCode = "Country Phone Code #5"
        ),
        MockCountry(
            countryCode = "Country Code #6",
            countryCounties = listOf(
                MockCounty(
                    countyName = "County #6",
                    countyId = 6,
                    countySubCounties = listOf(
                        MockSubCounty(
                            subCountyId = 6,
                            subCountyName = "SubCounty #6"
                        )
                    ),
                )
            ),
            countryName = "Country #6",
            countryCurrency = "Country Currency #6",
            countryId = 6,
            countryPhoneCode = "Country Phone Code #6"
        ),
        MockCountry(
            countryCode = "Country Code #7",
            countryCounties = listOf(
                MockCounty(
                    countyName = "County #7",
                    countyId = 7,
                    countySubCounties = listOf(
                        MockSubCounty(
                            subCountyId = 7,
                            subCountyName = "SubCounty #7"
                        )
                    ),
                )
            ),
            countryName = "Country #7",
            countryCurrency = "Country Currency #7",
            countryId = 7,
            countryPhoneCode = "Country Phone Code #7"
        ),
    ))

    override suspend fun getAllMockCountries(): Flow<List<MockCountry>> = flow {
        emit(value = Json.decodeFromString<List<MockCountry>>(string = mockCountries))
    }.flowOn(context = ioDispatcher)

    override suspend fun getMockCountryByName(countryName: String): MockCountry? {
        return withContext(context = ioDispatcher) {
            getAllMockCountries().first().find { it.countryName == countryName }
        }
    }

    override suspend fun getMockSubCountyById(countryId: Int): MockCounty? {
        return withContext(ioDispatcher) {
            getAllMockCountries()
                .map { countries ->
                    countries.flatMap { mockCountry ->
                        mockCountry.countryCounties
                    }
                }
                .firstOrNull()?.find { mockCounty ->
                    mockCounty.countyId == countryId
                }
        }
    }


}