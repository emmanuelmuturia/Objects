package cifor.icraf.objects.feature.ui.state

import cifor.icraf.objects.feature.data.models.Object

data class ObjectsUIState(
    val isLoading: Boolean = false,
    val objects: List<Object> = emptyList(),
    val error: String? = null
)