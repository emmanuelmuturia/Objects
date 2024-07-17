package cifor.icraf.rest.feature.data.repository

import cifor.icraf.rest.commons.state.NetworkResult
import cifor.icraf.rest.feature.data.model.Subject
import cifor.icraf.rest.feature.source.local.entity.RestEntity
import cifor.icraf.rest.feature.source.remote.dto.RestDTO
import kotlinx.coroutines.flow.Flow

interface RestRepository {

    suspend fun getAllSubjects() : Flow<List<Subject>>

}