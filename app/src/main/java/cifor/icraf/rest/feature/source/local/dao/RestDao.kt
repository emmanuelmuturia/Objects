package cifor.icraf.rest.feature.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import cifor.icraf.rest.feature.source.local.entity.RestEntity
import cifor.icraf.rest.feature.source.remote.dto.RestDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface RestDao {

    @Upsert
    suspend fun upsertRestDTO(restDTO: RestDTO)

    @Query(value = "SELECT * FROM RestEntity")
    fun getAllSubjects(): Flow<List<RestEntity>>

}