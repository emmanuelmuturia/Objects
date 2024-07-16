package cifor.icraf.rest.feature.source.remote.service

import cifor.icraf.rest.feature.source.remote.dto.RestDTO
import retrofit2.Response
import retrofit2.http.GET

fun interface RestApiService {

    @GET(value = "objects")
    suspend fun getAllSubjects() : Response<List<RestDTO>>

}