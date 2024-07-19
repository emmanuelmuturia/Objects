package cifor.icraf.objects.feature.ui.state

import cifor.icraf.objects.feature.data.models.Object
import cifor.icraf.objects.feature.data.models.ResponseObject

data class ObjectsUIState(
    val isLoading: Boolean = false,
    val objects: List<Object> = emptyList(),
    val responseObject: ResponseObject? = null,
    val error: String? = null
)