package cifor.icraf.objects.feature.source.remote.source

import cifor.icraf.objects.feature.source.local.room.dao.ObjectsDao
import cifor.icraf.objects.feature.source.remote.api.ObjectsApi
import cifor.icraf.objects.feature.source.remote.dto.CountryDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class RemoteSourceImplementation(
    private val objectsApi: ObjectsApi,
    private val objectsDao: ObjectsDao,
    private val ioDispatcher: CoroutineDispatcher
) : RemoteSource {

    override fun fetchAllCountries(): Flow<List<CountryDTO>> {
        TODO("Not yet implemented")
    }

}