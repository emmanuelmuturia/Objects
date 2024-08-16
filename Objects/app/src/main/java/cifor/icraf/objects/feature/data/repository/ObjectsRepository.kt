package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.models.Country
import cifor.icraf.objects.feature.data.models.County
import cifor.icraf.objects.feature.data.models.SubCounty
import kotlinx.coroutines.flow.Flow

interface ObjectsRepository {

    suspend fun getAllCountries(): Flow<List<Country>>

    //suspend fun upsertCountry(country: Country)

    suspend fun getCountiesById(countryId: Int): List<County>

    suspend fun getSubCountiesById(countyId: Int): List<SubCounty>

}