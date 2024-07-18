package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.models.Object
import cifor.icraf.objects.feature.source.local.entity.ObjectsEntity
import kotlinx.coroutines.flow.Flow

interface ObjectsRepository {

    suspend fun getAllObjects() : Flow<List<Object>>

}