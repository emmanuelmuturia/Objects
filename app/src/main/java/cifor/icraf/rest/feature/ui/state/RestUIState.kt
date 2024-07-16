package cifor.icraf.rest.feature.ui.state

import cifor.icraf.rest.feature.source.local.entity.RestEntity

data class RestUIState(
    val isLoading: Boolean = false,
    val subjects: List<RestEntity> = emptyList(),
    val error: String? = null
)