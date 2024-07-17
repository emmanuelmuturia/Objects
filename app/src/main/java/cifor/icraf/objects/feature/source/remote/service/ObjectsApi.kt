package cifor.icraf.objects.feature.source.remote.service

import cifor.icraf.objects.feature.source.remote.dto.ObjectsDTO
import retrofit2.Response
import retrofit2.http.GET

fun interface ObjectsApi {

    @GET(value = "objects")
    suspend fun getAllObjects() : Response<List<ObjectsDTO>>

}