package cifor.icraf

import cifor.icraf.objects.feature.data.models.Country
import cifor.icraf.objects.feature.data.repository.ObjectsRepository
import cifor.icraf.objects.feature.ui.viewmodel.ObjectsViewModel
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.mockkObject
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
    fun testGetCountries() = runTest {
        val countries = listOf(
            Country(
                countryId = 1,
                countryName = "Country #1",
                countryCurrency = "Kenyan Shilling (KES)",
                countryPhoneCode = "+254",
                countryCode = "KES",
                countryCounties = listOf()
            )
        )
        // Given...
        coEvery { objectsRepository.getAllCountries() } returns flowOf(countries)
        // When...
        objectsViewModel.getAllSubjects()
        objectsRepository.getAllCountries()
        // Then...
        val objectsUIState = objectsViewModel.objectsUIState.value
        assertEquals(countries, objectsUIState.objects)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

}