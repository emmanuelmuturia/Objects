package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.models.Object
import cifor.icraf.objects.feature.data.models.ResponseObject
import cifor.icraf.objects.feature.source.local.room.entities.ObjectsEntity
import cifor.icraf.objects.feature.source.local.room.source.LocalSource
import cifor.icraf.objects.feature.source.remote.dto.ObjectsDTO
import cifor.icraf.objects.feature.source.remote.source.RemoteSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ObjectsRepositoryImplementation(
    private val ioDispatcher: CoroutineDispatcher,
    private val localSource: LocalSource,
    private val remoteSource: RemoteSource
) : ObjectsRepository {

    override suspend fun getAllObjects(): Flow<List<Object>> {
        return withContext(context = ioDispatcher) {
            localSource.getAllObjects().map { objectEntities ->
                objectEntities.map { objectEntity ->
                    Object(
                        objectId = objectEntity.objectId,
                        objectName = objectEntity.objectName
                    )
                }
            }
        }
    }

    override suspend fun postObject(myObject: Object): ResponseObject? {
        return withContext(context = ioDispatcher) {
            val objectsResponse = remoteSource.postObject(
                ObjectsEntity(
                    objectId = myObject.objectId,
                    objectName = myObject.objectName
                )
            )

            objectsResponse?.let {
                ResponseObject(
                    objectId = it.objectId ?: "",
                    objectName = it.objectName ?: "",
                    objectCreatedAt = it.objectCreatedAt ?: ""
                )
            }
        }
    }

}