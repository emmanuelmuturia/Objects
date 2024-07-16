package cifor.icraf.rest.feature.data.repository

import cifor.icraf.rest.feature.source.local.dao.RestDao
import cifor.icraf.rest.feature.source.local.entity.RestEntity
import cifor.icraf.rest.feature.source.remote.service.RestApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

class RestRepositoryImplementation(
    private val restDao: RestDao,
    private val restApiService: RestApiService,
    private val ioDispatcher: CoroutineDispatcher
) : RestRepository {

    override suspend fun getAllSubjects(): Flow<List<RestEntity>> {
        return withContext(context = ioDispatcher) {
            restDao.getAllSubjects().onEach {
                if (it.isEmpty()) {
                    fetchSubjects()
                }
            }
        }
    }

    override suspend fun fetchSubjects() {
        withContext(context = ioDispatcher) {
            val response = restApiService.getAllSubjects()
            if (response.isSuccessful) {
                response.body()!!.map { restDTO ->
                    restDao.upsertRestDTO(restEntity = restDTO.toEntity())
                }
            }
        }
    }


}