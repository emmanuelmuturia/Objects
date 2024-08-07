package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.models.Country
import cifor.icraf.objects.feature.source.local.room.entities.CountryEntity
import cifor.icraf.objects.feature.source.local.room.source.LocalSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ObjectsRepositoryImplementation(
    private val ioDispatcher: CoroutineDispatcher,
    private val localSource: LocalSource
) : ObjectsRepository {

    override suspend fun getAllCountries(): Flow<List<Country>> {
        return withContext(context = ioDispatcher) {
            localSource.getAllCountries().map { countries ->
                countries.map { countryEntity ->
                    Country(
                        countryId = countryEntity.countryId,
                        countryName = countryEntity.countryName,
                        countryCurrency = countryEntity.countryCurrency,
                        countryCode = countryEntity.countryCode,
                        countryCounties = countryEntity.countryCounties,
                        countryPhoneCode = countryEntity.countryPhoneCode
                    )
                }
            }
        }
    }

    override suspend fun upsertCountry(country: Country) {
        localSource.upsertCountry(countryEntity = CountryEntity(
            countryId = country.countryId,
            countryName = country.countryName,
            countryCurrency = country.countryCurrency,
            countryCode = country.countryCode,
            countryCounties = country.countryCounties.map { it.toCountyEntity() },
            countryPhoneCode = country.countryPhoneCode
        ))
    }

}