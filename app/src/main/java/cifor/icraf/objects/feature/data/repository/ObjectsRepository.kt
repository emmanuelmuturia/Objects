package cifor.icraf.objects.feature.data.repository

import cifor.icraf.objects.feature.data.model.Object
import kotlinx.coroutines.flow.Flow

interface ObjectsRepository {

    suspend fun getAllObjects() : Flow<List<Object>>

}