package cifor.icraf.objects.feature.source.mock.source

import cifor.icraf.objects.feature.source.mock.model.MockCountry
import cifor.icraf.objects.feature.source.mock.model.MockCounty
import kotlinx.coroutines.flow.Flow

interface MockSource {

    suspend fun getAllMockCountries(): Flow<List<MockCountry>>

    suspend fun getCountryByName(countryName: String): MockCountry?

    suspend fun getSubCountiesById(countyId: Int): MockCounty?

}