package cifor.icraf.objects.feature.source.remote.source

import cifor.icraf.objects.feature.source.local.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.entity.ObjectsEntity
import cifor.icraf.objects.feature.source.remote.api.ObjectsApi
import kotlinx.coroutines.CoroutineDispatcher
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

}