package cifor.icraf

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import cifor.icraf.objects.feature.source.local.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.database.ObjectsDatabase
import cifor.icraf.objects.feature.source.local.entities.CountryEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(value = AndroidJUnit4::class)
class ObjectsDaoTest {

    private lateinit var objectsDatabase: ObjectsDatabase
    private lateinit var objectsDao: ObjectsDao

    @Before
    fun createDatabase() {
        objectsDatabase = Room.inMemoryDatabaseBuilder(
            context = ApplicationProvider.getApplicationContext(),
            klass = ObjectsDatabase::class.java
        ).allowMainThreadQueries().build()
        objectsDao = objectsDatabase.objectsDao()
    }

    @Test
    fun testInsertAndReadCountry() = runTest {
        val countryEntity = CountryEntity(
            countryId = 1,
            countryName = "Country #1",
            countryCurrency = "Kenyan Shilling (KES)",
            countryPhoneCode = "+254",
            countryCode = "KES",
            countryCounties = listOf()
        )
        objectsDao.upsertCountryEntity(
            countryEntity = countryEntity
        )
        val countryEntities = objectsDao.getAllCountries()
        assert(value = countryEntities.first().contains(element = countryEntity))
    }

    @After
    fun closeDatabase() {
        objectsDatabase.close()
    }

}