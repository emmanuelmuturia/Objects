package cifor.icraf.objects.feature.source.localMock.source

import cifor.icraf.objects.feature.source.localMock.model.MockCountry
import cifor.icraf.objects.feature.source.localMock.model.MockCounty
import kotlinx.coroutines.flow.Flow

interface MockSource {

    suspend fun getAllMockCountries(): Flow<List<MockCountry>>

    suspend fun getMockCountryByName(countryName: String): MockCountry?

    suspend fun getMockSubCountyById(countryId: Int): MockCounty?

}