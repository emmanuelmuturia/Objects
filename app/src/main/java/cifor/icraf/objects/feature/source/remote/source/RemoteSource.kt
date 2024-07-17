package cifor.icraf.objects.feature.source.remote.source

import cifor.icraf.objects.feature.source.remote.dto.ObjectsDTO
import cifor.icraf.objects.feature.source.remote.response.ObjectsResponse

interface RemoteSource {

    suspend fun fetchObjects()

    suspend fun postObject(objectsDTO: ObjectsDTO): ObjectsResponse

}