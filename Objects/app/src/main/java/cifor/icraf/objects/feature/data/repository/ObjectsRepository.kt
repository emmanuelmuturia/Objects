package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.models.Country
import kotlinx.coroutines.flow.Flow

interface ObjectsRepository {

    suspend fun getAllCountries(): Flow<List<Country>>

    suspend fun upsertCountry(country: Country)

}