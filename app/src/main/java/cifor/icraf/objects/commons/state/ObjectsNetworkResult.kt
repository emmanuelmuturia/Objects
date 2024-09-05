package cifor.icraf.objects.commons.state

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

sealed class ObjectsNetworkResult<out T> {
    data class Success<out T>(val data: T) : ObjectsNetworkResult<T>()
    data class Error(val error: String) : ObjectsNetworkResult<Nothing>()
}

fun <T> Flow<T>.asResult() : Flow<ObjectsNetworkResult<T>> {
    return this.map<T, ObjectsNetworkResult<T>> {
        ObjectsNetworkResult.Success(data = it)
    }.catch { emit(value = ObjectsNetworkResult.Error(error = it.message.toString())) }
}