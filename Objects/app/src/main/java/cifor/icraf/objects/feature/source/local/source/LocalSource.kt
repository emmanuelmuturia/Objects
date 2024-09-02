package cifor.icraf.objects.feature.source.local.source

import cifor.icraf.objects.feature.source.local.entities.CountryEntity
import cifor.icraf.objects.feature.source.local.entities.CountyEntity
import kotlinx.coroutines.flow.Flow

interface LocalSource {

    suspend fun getAllCountries(): Flow<List<CountryEntity>>

    suspend fun upsertCountry(countryEntity: CountryEntity)

    suspend fun getCountryByName(countryName: String): CountryEntity?

    suspend fun getCountyByName(countyName: String): CountyEntity?

}