package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.models.Object
import cifor.icraf.objects.feature.data.models.ResponseObject
import cifor.icraf.objects.feature.source.local.room.entities.ObjectsEntity
import cifor.icraf.objects.feature.source.remote.response.ObjectsResponse
import kotlinx.coroutines.flow.Flow

interface ObjectsRepository {

    suspend fun getAllObjects() : Flow<List<Object>>

    suspend fun postObject(myObject: Object): ResponseObject?

}