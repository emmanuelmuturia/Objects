package cifor.icraf.objects.feature.source.remoteMock.source

import cifor.icraf.objects.feature.source.remoteMock.model.RemoteMockCountry
import cifor.icraf.objects.feature.source.remoteMock.model.RemoteMockCounty
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException

class RemoteMockSourceImplementation(
    private val ioDispatcher: CoroutineDispatcher,
    private val okHttpClient: OkHttpClient
) : RemoteMockSource {

    override suspend fun getRemoteMockCountries(): Flow<List<RemoteMockCountry>> = flow {
        val networkRequest = Request.Builder()
            .url(url = "https://filesdownload.thegrit.earth/countries.json").build()
        okHttpClient.newCall(request = networkRequest).execute().use { networkResponse ->
            if (!networkResponse.isSuccessful) throw IOException("Unexpected Response: $networkResponse")
            val listOfCountries = Json.decodeFromString<List<RemoteMockCountry>>(string = networkResponse.body.toString())
            emit(value = listOfCountries)
        }
    }

    override suspend fun getMockCountryByName(countryName: String): RemoteMockCountry? {
        return withContext(context = ioDispatcher) {
            getRemoteMockCountries().first().find { it.countryName == countryName }
        }
    }

    override suspend fun getMockSubCountyById(countryId: Int): RemoteMockCounty? {
        return withContext(ioDispatcher) {
            getRemoteMockCountries()
                .map { countries ->
                    countries.flatMap { mockCountry ->
                        mockCountry.countryCounties
                    }
                }
                .firstOrNull()?.find { mockCounty ->
                    mockCounty.countyId == countryId
                }
        }
    }

}