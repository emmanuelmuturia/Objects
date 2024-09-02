package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.models.Country
import cifor.icraf.objects.feature.data.models.County
import cifor.icraf.objects.feature.data.models.toCounty
import cifor.icraf.objects.feature.data.models.toSubCounty
import cifor.icraf.objects.feature.source.local.source.LocalSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ObjectsRepositoryImplementation(
    private val ioDispatcher: CoroutineDispatcher,
    private val localSource: LocalSource
) : ObjectsRepository {

    override suspend fun getAllCountries(): Flow<List<Country>> {
        return withContext(context = ioDispatcher) {
            localSource.getAllCountries().map { countries ->
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
            }
        }
    }

    override suspend fun getCountryByName(countryName: String): Country? {
        return withContext(context = ioDispatcher) {
            val country = localSource.getCountryByName(countryName = countryName)
            country?.let { countryEntity ->
                Country(
                    countryId = countryEntity.countryId,
                    countryName = countryEntity.countryName,
                    countryCurrency = countryEntity.countryCurrency,
                    countryCode = countryEntity.countryCode,
                    countryCounties = countryEntity.countryCounties.map { countyEntity ->  countyEntity.toCounty() },
                    countryPhoneCode = countryEntity.countryPhoneCode
                )
            }
        }
    }

    override suspend fun getSubCountiesById(countryId: Int): County? {
        return withContext(context = ioDispatcher) {
            val county = localSource.getSubCountyById(countryId = countryId)
            county?.let { countyEntity ->
                County(
                    countyId = countyEntity.countyId,
                    countyName = countyEntity.countyName,
                    countySubCounties = countyEntity.countySubCounties.map { countySubCounties -> countySubCounties.toSubCounty() }
                )
            }
        }
    }

}