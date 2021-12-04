package feature.commons.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

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

// On tests
// internal fun convertErrorBody(throwable: HttpException): ErrorResponse? {
//    try {
//        val errorJsonString = throwable.response()?.errorBody()?.string()
//        return Gson().fromJson(errorJsonString, ErrorResponse::class.java)
//    } catch (exception: Exception) {
//        null
//    }
//    return EMPTY_API_ERROR
// }
