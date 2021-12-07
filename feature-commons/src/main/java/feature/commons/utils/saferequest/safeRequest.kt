package feature.commons.utils.saferequest

import feature.commons.utils.StateMachine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

suspend fun <T> safeRequest(
    apiCall: suspend () -> T
): StateMachine<T> {
    return withContext(Dispatchers.IO) {
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
