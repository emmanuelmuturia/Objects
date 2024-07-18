package cifor.icraf.objects.feature.source.remote.api

import cifor.icraf.objects.feature.source.remote.dto.ObjectsDTO
import retrofit2.Response
import retrofit2.http.GET

interface ObjectsApi {

    @GET(value = "objects")
    suspend fun getAllObjects() : Response<List<ObjectsDTO>>

}