package feature.commons.utils

import com.google.gson.Gson
import feature.commons.utils.ErrorResponse.Companion.EMPTY_API_ERROR
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend inline fun <T> safeRequest(
    dispatcher: CoroutineDispatcher,
    crossinline apiCall: suspend () -> T
): StateMachine<T> {
    return withContext(dispatcher) {
        try {
            StateMachine.Success(value = apiCall.invoke())
        } catch (e: Exception) {
            StateMachine.Failure(e)
        }
    }
}

internal fun convertErrorBody(throwable: HttpException): ErrorResponse? {
    try {
        val errorJsonString = throwable.response()?.errorBody()?.string()
        return Gson().fromJson(errorJsonString, ErrorResponse::class.java)
    } catch (exception: Exception) {
        null
    }
    return EMPTY_API_ERROR
}
