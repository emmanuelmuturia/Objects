package cifor.icraf.objects.feature.source.remote.api

import cifor.icraf.objects.feature.source.remote.dto.CountryDTO
import retrofit2.Response
import retrofit2.http.GET

interface ObjectsApi {

   @GET
   suspend fun getAllCountries(): Response<List<CountryDTO>>

}