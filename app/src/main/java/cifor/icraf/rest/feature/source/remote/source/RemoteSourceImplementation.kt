package cifor.icraf.rest.feature.source.remote.source

import cifor.icraf.rest.feature.source.local.dao.RestDao
import cifor.icraf.rest.feature.source.local.entity.RestEntity
import cifor.icraf.rest.feature.source.remote.service.RestApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RemoteSourceImplementation(
    private val restApiService: RestApiService,
    private val restDao: RestDao,
    private val ioDispatcher: CoroutineDispatcher
) : RemoteSource {

    override suspend fun fetchSubjects() {
        withContext(context = ioDispatcher) {
            val response = restApiService.getAllSubjects()
            if (response.isSuccessful) {
                response.body()!!.map { restDTO ->
                    restDao.upsertRestDTO(restEntity = RestEntity(
                        restId = restDTO.restId,
                        restName = restDTO.restName
                    ))
                }
            }
        }
    }

}