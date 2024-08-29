package cifor.icraf.objects.feature.source.remoteMock.source

import cifor.icraf.objects.feature.source.remoteMock.model.RemoteMockCountry
import cifor.icraf.objects.feature.source.remoteMock.model.RemoteMockCounty
import kotlinx.coroutines.flow.Flow

interface RemoteMockSource {

    suspend fun getRemoteMockCountries(): Flow<List<RemoteMockCountry>>

    suspend fun getMockCountryByName(countryName: String): RemoteMockCountry?

    suspend fun getMockSubCountyById(countryId: Int): RemoteMockCounty?

}