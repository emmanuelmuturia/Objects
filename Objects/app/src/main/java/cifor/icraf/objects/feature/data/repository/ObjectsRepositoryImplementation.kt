package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.models.Country
import cifor.icraf.objects.feature.data.models.County
import cifor.icraf.objects.feature.data.models.SubCounty
import cifor.icraf.objects.feature.data.models.toCounty
import cifor.icraf.objects.feature.data.models.toCountyEntity
import cifor.icraf.objects.feature.data.models.toSubCounty
import cifor.icraf.objects.feature.source.local.entities.CountryEntity
import cifor.icraf.objects.feature.source.local.source.LocalSource
import cifor.icraf.objects.feature.source.mock.source.MockSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ObjectsRepositoryImplementation(
    private val ioDispatcher: CoroutineDispatcher,
    private val localSource: LocalSource,
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

    override suspend fun getCountiesById(countryId: Int): List<County> {
        return withContext(context = ioDispatcher) {
            localSource.getCountiesById(countryId = countryId).map { countyEntity ->
                County(
                    countyId = countyEntity.countyId,
                    countyName = countyEntity.countyName,
                    countySubCounties = countyEntity.countySubCounties.map { it.toSubCounty() }
                )
            }
        }
    }

    override suspend fun getSubCountiesById(countyId: Int): List<SubCounty> {
        return withContext(context = ioDispatcher) {
            localSource.getSubCountiesById(countyId = countyId).map { subCountyEntity ->
                SubCounty(
                    subCountyId = subCountyEntity.subCountyId,
                    subCountyName = subCountyEntity.subCountyName
                )
            }
        }
    }

}