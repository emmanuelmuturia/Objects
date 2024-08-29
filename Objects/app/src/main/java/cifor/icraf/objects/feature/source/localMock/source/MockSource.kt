package cifor.icraf.objects.feature.source.localMock.source

import cifor.icraf.objects.feature.source.localMock.model.LocalMockCountry
import cifor.icraf.objects.feature.source.localMock.model.LocalMockCounty
import kotlinx.coroutines.flow.Flow

interface MockSource {

    suspend fun getAllMockCountries(): Flow<List<LocalMockCountry>>

    suspend fun getMockCountryByName(countryName: String): LocalMockCountry?

    suspend fun getMockSubCountyById(countryId: Int): LocalMockCounty?

}