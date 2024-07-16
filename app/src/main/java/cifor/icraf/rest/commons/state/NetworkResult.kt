package cifor.icraf.rest.commons.state

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

sealed class NetworkResult<out T> {
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Error(val error: String) : NetworkResult<Nothing>()
}

fun <T> Flow<T>.asResult() : Flow<NetworkResult<T>> {
    return this.map<T, NetworkResult<T>> {
        NetworkResult.Success(data = it)
    }.catch { emit(value = NetworkResult.Error(error = it.message.toString())) }
}