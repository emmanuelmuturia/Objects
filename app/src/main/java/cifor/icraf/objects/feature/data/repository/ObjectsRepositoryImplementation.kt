package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.models.Object
import cifor.icraf.objects.feature.data.models.PostedObject
import cifor.icraf.objects.feature.source.local.source.LocalSource
import cifor.icraf.objects.feature.source.remote.dto.ObjectsDTO
import cifor.icraf.objects.feature.source.remote.source.RemoteSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ObjectsRepositoryImplementation(
    private val ioDispatcher: CoroutineDispatcher,
    private val localSource: LocalSource,
    private val remoteSource: RemoteSource
) : ObjectsRepository {

    override suspend fun getAllObjects(): Flow<List<Object>> {
        return withContext(context = ioDispatcher) {
            localSource.getAllObjects().map { objectEntityList ->
                objectEntityList.map { objectEntity ->
                    Object(
                        objectId = objectEntity.objectId,
                        objectName = objectEntity.objectName
                    )
                }
            }
        }
    }

    override suspend fun postObject(objectsDTO: ObjectsDTO): PostedObject {
        return withContext(context = ioDispatcher) {
            val response = remoteSource.postObject(objectsDTO = objectsDTO)
            PostedObject(
                objectId = response.objectId,
                objectName = response.objectName,
                objectCreatedAt = response.objectCreatedAt
            )
        }
    }

}