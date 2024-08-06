package cifor.icraf.objects.feature.source.local.room.source

import cifor.icraf.objects.feature.source.local.room.entities.CountryEntity
import kotlinx.coroutines.flow.Flow

interface LocalSource {

    fun getAllCountries(): Flow<List<CountryEntity>>

    suspend fun upsertCountry(countryEntity: CountryEntity)

}