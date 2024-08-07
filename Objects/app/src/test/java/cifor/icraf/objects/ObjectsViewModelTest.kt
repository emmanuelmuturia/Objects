package cifor.icraf.objects

import cifor.icraf.objects.feature.data.repository.ObjectsRepository
import cifor.icraf.objects.feature.ui.viewmodel.ObjectsViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ObjectsViewModelTest {

    private val objectsRepository = mockk<ObjectsRepository>(relaxed = true)
    private lateinit var objectsViewModel: ObjectsViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher = Dispatchers.Unconfined)
        objectsViewModel = ObjectsViewModel(objectsRepository = objectsRepository)
    }

    @Test
    fun testGetAllObjects() = runTest {
        val objects = listOf(
            Object(
                objectId = "#1",
                objectName = "Object #1"
            )
        )
        // Given...
        coEvery { objectsRepository.getAllObjects() } returns flowOf(value = objects)
        // When...
        objectsViewModel.getAllSubjects()
        coVerify { objectsRepository.getAllObjects() }
        // Then...
        val objectsUIState = objectsViewModel.objectsUIState.value
        assertEquals(objects, objectsUIState.objects)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

}