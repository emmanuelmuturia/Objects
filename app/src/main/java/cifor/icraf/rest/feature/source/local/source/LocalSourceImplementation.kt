package cifor.icraf.rest.feature.source.local.source

import cifor.icraf.rest.feature.source.local.dao.RestDao
import cifor.icraf.rest.feature.source.local.entity.RestEntity
import cifor.icraf.rest.feature.source.remote.source.RemoteSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

class LocalSourceImplementation(
    private val restDao: RestDao,
    private val ioDispatcher: CoroutineDispatcher,
    private val remoteSource: RemoteSource
) : LocalSource {

    override suspend fun getAllSubjects(): Flow<List<RestEntity>> {
        return withContext(context = ioDispatcher) {
            restDao.getAllSubjects().onEach {
                if (it.isEmpty()) {
                    remoteSource.fetchSubjects()
                }
            }
        }
    }

}