package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.model.Object
import cifor.icraf.objects.feature.source.local.source.LocalSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ObjectsRepositoryImplementation(
    private val ioDispatcher: CoroutineDispatcher,
    private val localSource: LocalSource
) : ObjectsRepository {

    override suspend fun getAllObjects(): Flow<List<Object>> {
        return withContext(context = ioDispatcher) {
            localSource.getAllObjects().map { objectEntityList ->
                objectEntityList.map { objectEntity ->
                    Object(
                        restId = objectEntity.objectId,
                        restName = objectEntity.objectName
                    )
                }
            }
        }
    }

}