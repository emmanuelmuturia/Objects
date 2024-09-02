package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.models.Country
import cifor.icraf.objects.feature.data.models.County
import kotlinx.coroutines.flow.Flow

interface ObjectsRepository {

    suspend fun getAllCountries(): Flow<List<Country>>

    suspend fun getCountryByName(countryName: String): Country?

    suspend fun getSubCountiesById(countryId: Int): County?

}