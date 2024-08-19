package cifor.icraf.objects.feature.source.local.source

import cifor.icraf.objects.feature.data.models.County
import cifor.icraf.objects.feature.data.models.SubCounty
import cifor.icraf.objects.feature.source.local.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.entities.CountryEntity
import cifor.icraf.objects.feature.source.local.entities.CountyEntity
import cifor.icraf.objects.feature.source.local.entities.SubCountyEntity
import cifor.icraf.objects.feature.source.remote.source.RemoteSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

class LocalSourceImplementation(
    private val objectsDao: ObjectsDao,
    private val ioDispatcher: CoroutineDispatcher,
    private val remoteSource: RemoteSource
) : LocalSource {

    override suspend fun getAllCountries(): Flow<List<CountryEntity>> {
        return withContext(context = ioDispatcher) {
            objectsDao.getAllCountries().map { countryEntities ->
                countryEntities.map { countryEntity ->
                    CountryEntity(
                        countryId = countryEntity.countryId,
                        countryName = countryEntity.countryName,
                        countryCurrency = countryEntity.countryCurrency,
                        countryCode = countryEntity.countryCode,
                        countryCounties = countryEntity.countryCounties,
                        countryPhoneCode = countryEntity.countryPhoneCode
                    )
                }
            }
        }.onEach {
            if (it.isEmpty()) {
                remoteSource.fetchAllCountries()
            }
        }
    }

    override suspend fun upsertCountry(countryEntity: CountryEntity) {
        withContext(context = ioDispatcher) {
            objectsDao.upsertCountryEntity(countryEntity = countryEntity)
        }
    }

    override suspend fun getCountiesById(countryId: Int): CountryEntity? {
        return withContext(context = ioDispatcher) {
            getAllCountries().first().find { it.countryId == countryId }
        }
    }

    override suspend fun getSubCountiesById(countyId: Int): CountyEntity? {
        return withContext(context = ioDispatcher) {
            getAllCountries() // Returns a Flow<List<CountryEntity>>
                .map { countries ->
                    countries.flatMap { countryEntity ->
                        countryEntity.countryCounties // List<CountyEntity>
                    }
                }
                .firstOrNull { countyList ->
                    countyList.find { countyEntity ->
                        countyEntity.countyId == countyId
                    } != null
                }?.find { countyEntity ->
                    countyEntity.countyId == countyId
                }
        }
    }


}