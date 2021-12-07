package feature.commons.utils.saferequest

import feature.commons.utils.StateMachine
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.HttpException

/**
 * We can use "dispatcher" for tests
 */
suspend fun <T> safeRequest(
    dispatcher: CoroutineDispatcher = IO,
    apiCall: suspend () -> T
): StateMachine<T> {
    return withContext(dispatcher) {
        runCatching { StateMachine.Success(apiCall()) }.getOrElse { throwable ->
            when (throwable) {
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = convertErrorBody(throwable)
                    StateMachine.ApiError(code, errorResponse)
                }
                else -> StateMachine.UnknownError
            }
        }
    }
}
