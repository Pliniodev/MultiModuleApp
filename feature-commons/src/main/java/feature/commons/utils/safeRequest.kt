package feature.commons.utils

import com.google.gson.Gson
import feature.commons.utils.ErrorResponse.Companion.EMPTY_API_ERROR
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

/**Retorna o FactsResult de acordo com o response da Api
 * apiCall = pede a função estendida(extension) na função suspensa que é feita na api(ChuckNorrisApi)**/

suspend fun <T> safeRequest(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): StateMachine<T> {
    return withContext(dispatcher) {
        try {
            StateMachine.Success(value = apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> StateMachine.ConnectionError
                is HttpException -> {
                    val code = throwable.code()
                    val errorResponse = convertErrorBody(throwable)
                    StateMachine.ApiError(code, errorResponse)
                }
                else -> StateMachine.ServerError
            }
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
