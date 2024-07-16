package cifor.icraf.rest.feature.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cifor.icraf.rest.commons.state.NetworkResult
import cifor.icraf.rest.commons.state.asResult
import cifor.icraf.rest.feature.data.repository.RestRepository
import cifor.icraf.rest.feature.ui.state.RestUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RestViewModel(
    private val restRepository: RestRepository
) : ViewModel() {

    val restUIState = MutableStateFlow(value = RestUIState())

    private fun getAllSubjects() {
        restUIState.value = RestUIState(isLoading = true)
        viewModelScope.launch {
            restRepository.getAllSubjects().asResult().collect { result ->
                when (result) {

                    is NetworkResult.Success -> {
                        restUIState.update {
                            it.copy(isLoading = false, subjects = result.data)
                        }
                    }

                    is NetworkResult.Error -> {
                        restUIState.update {
                            it.copy(isLoading = false, error = result.error)
                        }
                    }

                }
            }
        }
    }

}