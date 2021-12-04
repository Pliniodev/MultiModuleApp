package feature.commons.utils

sealed class StateMachine<out T> {
    data class Success<out T>(val value: T) : StateMachine<T>()
    data class ApiError(
        val statusCode: Int,
        val error: ErrorResponse? = null
    ) : StateMachine<Nothing>()
    object ConnectionError : StateMachine<Nothing>()
    object ServerError : StateMachine<Nothing>()
    object Loading : StateMachine<Nothing>()
}
