package cifor.icraf.objects.feature.source.remote.source

import cifor.icraf.objects.feature.source.local.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.entities.CountryEntity
import cifor.icraf.objects.feature.source.remote.api.ObjectsApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class RemoteSourceImplementation(
    private val objectsApi: ObjectsApi,
    private val ioDispatcher: CoroutineDispatcher,
    private val objectsDao: ObjectsDao
) : RemoteSource {

    override suspend fun fetchAllCountries() {
        withContext(context = ioDispatcher) {
            val response = objectsApi.fetchAllCountries()
            if (response.isSuccessful) {
                response.body()?.map { countryDTO ->
                    objectsDao.upsertCountryEntity(
                        countryEntity = CountryEntity(
                            countryId = countryDTO.countryId,
                            countryName = countryDTO.countryName,
                            countryCurrency = countryDTO.countryCurrency,
                            countryCode = countryDTO.countryCode,
                            countryCounties = countryDTO.countryCounties.map { it.toCountyEntity() },
                            countryPhoneCode = countryDTO.countryPhoneCode
                        )
                    )
                }
            }
        }
    }

}