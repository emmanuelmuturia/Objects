package cifor.icraf.objects.feature.source.remoteMock.source

import cifor.icraf.objects.feature.source.remoteMock.model.RemoteMockCountry
import cifor.icraf.objects.feature.source.remoteMock.model.RemoteMockCounty
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class RemoteMockSourceImplementation(
    private val ioDispatcher: CoroutineDispatcher
) : RemoteMockSource {

    override suspend fun getRemoteMockCountries(): Flow<List<RemoteMockCountry>> = flow {
        /*
        1. Download the file...
        2. Retrieve the file...
        3. Parse the file and get the JSON String...
        4. Deserialise the JSON String to match the Serializable Data Classes...
        5. Emit the result...
         */
    }

    override suspend fun getMockCountryByName(countryName: String): RemoteMockCountry? {
        return withContext(context = ioDispatcher) {
            getRemoteMockCountries().first().find { it.countryName == countryName }
        }
    }

    override suspend fun getMockSubCountyById(countryId: Int): RemoteMockCounty? {
        return withContext(ioDispatcher) {
            getRemoteMockCountries()
                .map { countries ->
                    countries.flatMap { mockCountry ->
                        mockCountry.countryCounties
                    }
                }
                .firstOrNull()?.find { mockCounty ->
                    mockCounty.countyId == countryId
                }
        }
    }

}