package cifor.icraf.objects.feature.source.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import cifor.icraf.objects.feature.source.local.room.entities.ObjectsEntity
import cifor.icraf.objects.feature.source.local.room.entities.ObjectsResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ObjectsDao {

    @Upsert
    suspend fun upsertObjectEntity(objectsEntity: ObjectsEntity)

    @Query(value = "SELECT * FROM ObjectsEntity")
    fun getAllObjects(): Flow<List<ObjectsEntity>>

    @Upsert
    suspend fun upsertObjectsResponseEntity(objectsResponseEntity: ObjectsResponseEntity)

    @Query(value = "SELECT * FROM ObjectsResponseEntity")
    fun getAllResponseObjects(): Flow<ObjectsResponseEntity>

}