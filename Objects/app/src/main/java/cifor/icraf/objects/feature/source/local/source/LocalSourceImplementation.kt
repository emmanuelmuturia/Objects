package cifor.icraf.objects.feature.source.local.source

import cifor.icraf.objects.feature.source.local.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.entities.CountryEntity
import cifor.icraf.objects.feature.source.local.entities.CountyEntity
import cifor.icraf.objects.feature.source.remote.source.RemoteSource
import cifor.icraf.objects.feature.source.remoteMock.source.RemoteMockSource
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
    private val remoteSource: RemoteSource,
    private val remoteMockSource: RemoteMockSource
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
                //remoteSource.fetchAllCountries()
                remoteMockSource.getRemoteMockCountries()
            }
        }
    }

    override suspend fun upsertCountry(countryEntity: CountryEntity) {
        withContext(context = ioDispatcher) {
            objectsDao.upsertCountryEntity(countryEntity = countryEntity)
        }
    }

    override suspend fun getCountryByName(countryName: String): CountryEntity? {
        return withContext(context = ioDispatcher) {
            getAllCountries().first().find { countryEntity ->
                countryEntity.countryName == countryName
            }
        }
    }

    override suspend fun getSubCountyById(countryId: Int): CountyEntity? {
        return withContext(context = ioDispatcher) {
            getAllCountries().map { countryEntities ->
                countryEntities.flatMap { countryEntity ->
                    countryEntity.countryCounties
                }
            }.firstOrNull()?.find { countyEntity ->
                countyEntity.countyId == countryId
            }
        }
    }

}