package cifor.icraf.objects.feature.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import cifor.icraf.objects.feature.source.local.entity.ObjectsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ObjectsDao {

    @Upsert
    suspend fun upsertObjectEntity(objectsEntity: ObjectsEntity)

    @Query(value = "SELECT * FROM ObjectsEntity")
    fun getAllObjects(): Flow<List<ObjectsEntity>>

}