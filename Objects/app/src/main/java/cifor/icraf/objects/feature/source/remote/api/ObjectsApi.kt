package cifor.icraf.objects.feature.source.remote.api

import cifor.icraf.objects.feature.source.local.room.entities.ObjectsEntity
import cifor.icraf.objects.feature.source.remote.dto.ObjectsDTO
import cifor.icraf.objects.feature.source.remote.response.ObjectsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ObjectsApi {

    @GET(value = "objects")
    suspend fun getAllObjects() : Response<List<ObjectsDTO>>

    @POST(value = "objects")
    suspend fun postObject(@Body objectsEntity: ObjectsEntity): Response<ObjectsResponse>

}