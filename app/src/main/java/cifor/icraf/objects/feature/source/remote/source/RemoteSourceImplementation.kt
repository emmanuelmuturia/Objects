package cifor.icraf.objects.feature.source.remote.source

import cifor.icraf.objects.feature.source.local.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.entities.ObjectsEntity
import cifor.icraf.objects.feature.source.local.entities.ObjectsResponseEntity
import cifor.icraf.objects.feature.source.remote.api.ObjectsApi
import cifor.icraf.objects.feature.source.remote.dto.ObjectsDTO
import cifor.icraf.objects.feature.source.remote.response.ObjectsResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class RemoteSourceImplementation(
    private val objectsApi: ObjectsApi,
    private val objectsDao: ObjectsDao,
    private val ioDispatcher: CoroutineDispatcher
) : RemoteSource {

    override suspend fun fetchObjects() {
        withContext(context = ioDispatcher) {
            val response = objectsApi.getAllObjects()
            if (response.isSuccessful) {
                response.body()!!.map { objectsDTO ->
                    objectsDao.upsertObjectEntity(objectsEntity = ObjectsEntity(
                        objectId = objectsDTO.objectId,
                        objectName = objectsDTO.objectName
                    ))
                }
            }
        }
    }

    override suspend fun postObject(objectsEntity: ObjectsEntity): ObjectsResponse {
        return withContext(context = ioDispatcher) {
            objectsApi.postObject(objectsEntity = objectsEntity).body()!!
        }
    }

}