package cifor.icraf.objects.feature.ui.state

data class ObjectsUIState(
    val isLoading: Boolean = false,
    val objects: List<Object> = emptyList(),
    val responseObject: ResponseObject? = null,
    val error: String? = null
)