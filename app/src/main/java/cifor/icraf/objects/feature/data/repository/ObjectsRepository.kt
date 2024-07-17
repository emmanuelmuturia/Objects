package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.models.Object
import cifor.icraf.objects.feature.data.models.PostedObject
import cifor.icraf.objects.feature.source.remote.dto.ObjectsDTO
import kotlinx.coroutines.flow.Flow

interface ObjectsRepository {

    suspend fun getAllObjects() : Flow<List<Object>>

    suspend fun postObject(objectsDTO: ObjectsDTO) : PostedObject

}