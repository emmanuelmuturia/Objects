package cifor.icraf.objects.feature.source.local.source

import cifor.icraf.objects.feature.source.local.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.entity.ObjectsEntity
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

    override suspend fun getAllObjects(): Flow<List<ObjectsEntity>> {
        return withContext(context = ioDispatcher) {
            objectsDao.getAllObjects().onEach { objectEntities ->
                if (objectEntities.isEmpty()) {
                    remoteSource.fetchObjects()
                }
            }
        }
    }

}