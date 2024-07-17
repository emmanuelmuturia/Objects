package cifor.icraf.rest.feature.source.remote.source

import cifor.icraf.rest.feature.source.remote.dto.RestDTO
import kotlinx.coroutines.flow.Flow

interface RemoteSource {

    suspend fun fetchSubjects()

}