package cifor.icraf.objects.feature.source.remote.source

import cifor.icraf.objects.feature.source.remote.api.ObjectsApi
import cifor.icraf.objects.feature.source.remote.dto.CountryDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class RemoteSourceImplementation(
    private val objectsApi: ObjectsApi,
    private val ioDispatcher: CoroutineDispatcher
) : RemoteSource {

    override fun fetchAllCountries(): Flow<List<CountryDTO>> = flow {
        withContext(context = ioDispatcher) {
            objectsApi.fetchAllCountries().body()?.let { emit(value = it) }
        }
    }

}