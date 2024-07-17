package cifor.icraf.objects.feature.source.remote.service

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
    suspend fun putObject(@Body objectsDTO: ObjectsDTO): Response<ObjectsResponse>

}