package cifor.icraf.objects.feature.source.local.source

import cifor.icraf.objects.feature.source.local.entity.ObjectsEntity
import kotlinx.coroutines.flow.Flow

interface LocalSource {

    suspend fun getAllObjects(): Flow<List<ObjectsEntity>>

}