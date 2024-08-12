package cifor.icraf.objects.feature.source.mock.source

import cifor.icraf.objects.feature.source.mock.model.MockCountry
import kotlinx.coroutines.flow.Flow

interface MockSource {

    suspend fun getAllMockCountries(): Flow<List<MockCountry>>

}