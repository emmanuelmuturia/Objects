package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.models.Country
import cifor.icraf.objects.feature.data.models.Object
import cifor.icraf.objects.feature.data.models.ResponseObject
import cifor.icraf.objects.feature.source.local.room.entities.CountryEntity
import kotlinx.coroutines.flow.Flow

interface ObjectsRepository {

    suspend fun getAllCountries(): Flow<List<Country>>

    suspend fun upsertCountry(country: Country)

}