package cifor.icraf.objects.feature.ui.state

import cifor.icraf.objects.feature.data.models.Country

data class ObjectsUIState(
    val isLoading: Boolean = false,
    val objects: List<Country> = emptyList(),
    val error: String? = null
)