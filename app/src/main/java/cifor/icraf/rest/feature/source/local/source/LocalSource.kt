package cifor.icraf.rest.feature.source.local.source

import cifor.icraf.rest.feature.source.local.entity.RestEntity
import kotlinx.coroutines.flow.Flow

interface LocalSource {

    suspend fun getAllSubjects(): Flow<List<RestEntity>>

}