package cifor.icraf.objects.feature.source.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import cifor.icraf.objects.feature.source.local.room.entities.CountryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ObjectsDao {

    @Query(value = "SELECT * FROM CountryEntity")
    fun getAllCountries(): Flow<List<CountryEntity>>

    @Upsert
    suspend fun upsertCountryEntity(countryEntity: CountryEntity)

}