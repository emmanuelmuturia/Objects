package cifor.icraf.objects.feature.source.remote.source

import cifor.icraf.objects.feature.source.remote.dto.CountryDTO
import kotlinx.coroutines.flow.Flow

interface RemoteSource {

    fun fetchAllCountries(): Flow<List<CountryDTO>>

}