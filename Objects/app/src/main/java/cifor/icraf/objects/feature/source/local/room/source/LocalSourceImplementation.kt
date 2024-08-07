package cifor.icraf.objects.feature.source.local.room.source

import cifor.icraf.objects.feature.source.local.room.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.room.entities.CountryEntity
import cifor.icraf.objects.feature.source.remote.source.RemoteSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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

}