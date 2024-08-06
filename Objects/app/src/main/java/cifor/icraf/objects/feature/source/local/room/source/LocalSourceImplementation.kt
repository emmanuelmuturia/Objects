package cifor.icraf.objects.feature.source.local.room.source

import cifor.icraf.objects.feature.source.local.room.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.room.entities.CountryEntity
import cifor.icraf.objects.feature.source.remote.source.RemoteSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

class LocalSourceImplementation(
    private val objectsDao: ObjectsDao,
    private val ioDispatcher: CoroutineDispatcher,
    private val remoteSource: RemoteSource
) : LocalSource {

    override fun getAllCountries(): Flow<List<CountryEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun upsertCountry(countryEntity: CountryEntity) {
        TODO("Not yet implemented")
    }

}