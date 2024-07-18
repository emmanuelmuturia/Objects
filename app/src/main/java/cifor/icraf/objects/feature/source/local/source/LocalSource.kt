package cifor.icraf.objects.feature.source.local.source

import cifor.icraf.objects.feature.source.local.entities.ObjectsEntity
import cifor.icraf.objects.feature.source.local.entities.ObjectsResponseEntity
import cifor.icraf.objects.feature.source.remote.dto.ObjectsDTO
import kotlinx.coroutines.flow.Flow

interface LocalSource {

    suspend fun getAllObjects(): Flow<List<ObjectsEntity>>

}