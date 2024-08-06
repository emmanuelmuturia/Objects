package cifor.icraf.objects

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import cifor.icraf.objects.feature.source.local.room.dao.ObjectsDao
import cifor.icraf.objects.feature.source.local.room.database.ObjectsDatabase
import cifor.icraf.objects.feature.source.local.room.entities.ObjectsEntity
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
            ApplicationProvider.getApplicationContext(),
            ObjectsDatabase::class.java,
        ).allowMainThreadQueries().build()
        objectsDao = objectsDatabase.objectsDao()
    }

    @Test
    fun testUpsertObjects() = runTest {
        // Given an Object...
        val objectsEntity = ObjectsEntity(
            objectId = "#1",
            objectName = "Object #1"
        )
        // Insert it into the Database...
        objectsDao.upsertObjectEntity(objectsEntity = objectsEntity)
        // Check if it is in the Database...
        val objectEntities = objectsDao.getAllObjects()
        assert(objectEntities.first().contains(element = objectsEntity))
    }

    @After
    fun closeDatabase() {
        objectsDatabase.close()
    }

}