package cifor.icraf.objects.feature.source.remoteMock.source

import android.util.Log
import cifor.icraf.objects.feature.source.local.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.entities.CountryEntity
import cifor.icraf.objects.feature.source.remoteMock.model.RemoteMockCountry
import cifor.icraf.objects.feature.source.remoteMock.model.toCountyEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException

class RemoteMockSourceImplementation(
    private val ioDispatcher: CoroutineDispatcher,
    private val okHttpClient: OkHttpClient,
    private val objectsDao: ObjectsDao
) : RemoteMockSource {

    override suspend fun getRemoteMockCountries() {
        withContext(context = ioDispatcher) {
            val networkRequest = Request.Builder()
                .url(url = "https://filesdownload.thegrit.earth/countries.json").build()
            okHttpClient.newCall(request = networkRequest).execute().use { networkResponse ->
                val listOfCountries = Json.decodeFromString<List<RemoteMockCountry>>(string = networkResponse.body.toString())
                if (!networkResponse.isSuccessful) {
                    throw IOException("Unexpected Response: $networkResponse")
                } else {
                    listOfCountries.map { remoteMockCountry ->
                        objectsDao.upsertCountryEntity(
                            countryEntity = CountryEntity(
                                countryId = remoteMockCountry.countryId,
                                countryName = remoteMockCountry.countryName,
                                countryCurrency = remoteMockCountry.countryCurrency,
                                countryCode = remoteMockCountry.countryCode,
                                countryCounties = remoteMockCountry.countryCounties.map { it.toCountyEntity() },
                                countryPhoneCode = remoteMockCountry.countryPhoneCode
                            )
                        )
                    }
                }
            }
        }
    }

}