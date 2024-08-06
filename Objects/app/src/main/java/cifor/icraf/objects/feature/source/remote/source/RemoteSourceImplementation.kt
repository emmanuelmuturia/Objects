package cifor.icraf.objects.feature.source.remote.source

import cifor.icraf.objects.feature.source.local.room.dao.ObjectsDao
import cifor.icraf.objects.feature.source.remote.api.ObjectsApi
import kotlinx.coroutines.CoroutineDispatcher

class RemoteSourceImplementation(
    private val objectsApi: ObjectsApi,
    private val objectsDao: ObjectsDao,
    private val ioDispatcher: CoroutineDispatcher
) : RemoteSource {

    // Override the Repository Functions...

}