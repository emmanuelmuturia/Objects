package cifor.icraf.objects.feature.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cifor.icraf.objects.commons.state.NetworkResult
import cifor.icraf.objects.commons.state.asResult
import cifor.icraf.objects.feature.data.repository.ObjectsRepository
import cifor.icraf.objects.feature.ui.state.ObjectsUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ObjectsViewModel(
    private val objectsRepository: ObjectsRepository
) : ViewModel() {

    val objectsUIState = MutableStateFlow(value = ObjectsUIState())

    init {
        getAllSubjects()
    }

    fun getAllSubjects() {
        objectsUIState.value = ObjectsUIState(isLoading = true)
        viewModelScope.launch {
            objectsRepository.getAllCountries().asResult().collect { result ->
                when (result) {

                    is NetworkResult.Success -> {
                        objectsUIState.update {
                            it.copy(isLoading = false, objects = result.data)
                        }
                    }

                    is NetworkResult.Error -> {
                        objectsUIState.update {
                            it.copy(isLoading = false, error = result.error)
                        }
                    }

                }
            }
        }
    }

}