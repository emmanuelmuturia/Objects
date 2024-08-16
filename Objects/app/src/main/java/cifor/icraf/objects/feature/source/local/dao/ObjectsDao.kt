package cifor.icraf.objects.feature.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import cifor.icraf.objects.feature.source.local.entities.CountryEntity
import cifor.icraf.objects.feature.source.local.entities.CountyEntity
import cifor.icraf.objects.feature.source.local.entities.SubCountyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ObjectsDao {

    @Query(value = "SELECT * FROM CountryEntity")
    fun getAllCountries(): Flow<List<CountryEntity>>

    @Upsert
    suspend fun upsertCountryEntity(countryEntity: CountryEntity)

    @Query(value = "SELECT * FROM CountyEntity WHERE countyId = :countryId")
    suspend fun getAllCountiesById(countryId: Int): List<CountyEntity>

    @Query(value = "SELECT * FROM SubCountyEntity WHERE subCountyId = :countyId")
    suspend fun getAllSubCountiesById(countyId: Int): List<SubCountyEntity>

}