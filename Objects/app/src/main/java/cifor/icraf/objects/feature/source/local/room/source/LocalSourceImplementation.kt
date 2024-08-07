package cifor.icraf.objects.feature.source.local.room.source

import cifor.icraf.objects.feature.source.local.room.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.room.entities.CountryEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class LocalSourceImplementation(
    private val objectsDao: ObjectsDao,
    private val ioDispatcher: CoroutineDispatcher
) : LocalSource {

    override suspend fun getAllCountries(): Flow<List<CountryEntity>> {
        return withContext(context = ioDispatcher) {
            objectsDao.getAllCountries()
        }
    }

    override suspend fun upsertCountry(countryEntity: CountryEntity) {
        withContext(context = ioDispatcher) {
            objectsDao.upsertCountryEntity(countryEntity = countryEntity)
        }
    }

}