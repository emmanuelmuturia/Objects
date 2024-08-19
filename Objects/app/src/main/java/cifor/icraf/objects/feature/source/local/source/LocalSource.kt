package cifor.icraf.objects.feature.source.local.source

import cifor.icraf.objects.feature.data.models.County
import cifor.icraf.objects.feature.data.models.SubCounty
import cifor.icraf.objects.feature.source.local.entities.CountryEntity
import cifor.icraf.objects.feature.source.local.entities.CountyEntity
import cifor.icraf.objects.feature.source.local.entities.SubCountyEntity
import cifor.icraf.objects.feature.source.mock.model.MockCountry
import kotlinx.coroutines.flow.Flow

interface LocalSource {

    suspend fun getAllCountries(): Flow<List<CountryEntity>>

    suspend fun upsertCountry(countryEntity: CountryEntity)

    suspend fun getCountiesById(countryId: Int): CountryEntity?

    suspend fun getSubCountiesById(countyId: Int): CountyEntity?

}