package cifor.icraf.objects.feature.source.mock.source

import cifor.icraf.objects.feature.source.mock.model.MockCountry
import cifor.icraf.objects.feature.source.mock.model.MockCounty
import kotlinx.coroutines.flow.Flow

interface MockSource {

    suspend fun getAllMockCountries(): Flow<List<MockCountry>>

    suspend fun getMockCountryByName(countryName: String): MockCountry?

    suspend fun getMockSubCountiesById(countryId: Int): MockCounty?

}