package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.models.Country
import cifor.icraf.objects.feature.data.models.County
import cifor.icraf.objects.feature.data.models.toCounty
import cifor.icraf.objects.feature.data.models.toSubCounty
import cifor.icraf.objects.feature.source.localMock.source.MockSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ObjectsRepositoryImplementation(
    private val ioDispatcher: CoroutineDispatcher,
    //private val localSource: LocalSource,
    private val mockSource: MockSource
) : ObjectsRepository {

    override suspend fun getAllCountries(): Flow<List<Country>> {
        return withContext(context = ioDispatcher) {
            /*localSource.getAllCountries().map { countries ->
                countries.map { countryEntity ->
                    Country(
                        countryId = countryEntity.countryId,
                        countryName = countryEntity.countryName,
                        countryCurrency = countryEntity.countryCurrency,
                        countryCode = countryEntity.countryCode,
                        countryCounties = countryEntity.countryCounties.map { it.toCounty() },
                        countryPhoneCode = countryEntity.countryPhoneCode
                    )
                }
            }*/
            mockSource.getAllMockCountries().map { mockCountries ->
                mockCountries.map { mockCountry ->
                    Country(
                        countryId = mockCountry.countryId,
                        countryName = mockCountry.countryName,
                        countryCurrency = mockCountry.countryCurrency,
                        countryCode = mockCountry.countryCode,
                        countryCounties = mockCountry.countryCounties.map { it.toCounty() },
                        countryPhoneCode = mockCountry.countryPhoneCode
                    )
                }
            }
        }
    }

    /*override suspend fun upsertCountry(country: Country) {
        localSource.upsertCountry(countryEntity = CountryEntity(
            countryId = country.countryId,
            countryName = country.countryName,
            countryCurrency = country.countryCurrency,
            countryCode = country.countryCode,
            countryCounties = country.countryCounties.map { it.toCountyEntity() },
            countryPhoneCode = country.countryPhoneCode
        )
        )
    }*/

    override suspend fun getCountryByName(countryName: String): Country? {
        return withContext(context = ioDispatcher) {
            /*val country = localSource.getCountryByName(countryName = countryName)
            country?.let { countryEntity ->
                Country(
                    countryId = countryEntity.countryId,
                    countryName = countryEntity.countryName,
                    countryCurrency = countryEntity.countryCurrency,
                    countryCode = countryEntity.countryCode,
                    countryCounties = countryEntity.countryCounties.map { countyEntity ->  countyEntity.toCounty() },
                    countryPhoneCode = countryEntity.countryPhoneCode
                )
            }*/
            val country = mockSource.getMockCountryByName(countryName = countryName)
            country?.let { mockCountry ->
                Country(
                    countryId = mockCountry.countryId,
                    countryName = mockCountry.countryName,
                    countryCurrency = mockCountry.countryCurrency,
                    countryCode = mockCountry.countryCode,
                    countryCounties = mockCountry.countryCounties.map { countyEntity ->  countyEntity.toCounty() },
                    countryPhoneCode = mockCountry.countryPhoneCode
                )
            }
        }
    }

    override suspend fun getSubCountiesById(countryId: Int): County? {
        return withContext(context = ioDispatcher) {
            /*val county = localSource.getSubCountyById(countryId = countryId)
            county?.let { countyEntity ->
                County(
                    countyId = countyEntity.countyId,
                    countyName = countyEntity.countyName,
                    countySubCounties = countyEntity.countySubCounties.map { countySubCounties -> countySubCounties.toSubCounty() }
                )
            }*/
            val county = mockSource.getMockSubCountyById(countryId = countryId)
            county?.let { mockCounty ->
                County(
                    countyId = mockCounty.countyId,
                    countyName = mockCounty.countyName,
                    countySubCounties = mockCounty.countySubCounties.map { countySubCounties -> countySubCounties.toSubCounty() }
                )
            }
        }
    }

}