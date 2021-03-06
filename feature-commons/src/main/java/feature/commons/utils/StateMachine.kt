package feature.commons.utils

import feature.commons.utils.saferequest.ErrorResponse

/**
 * To understand about safeApiCall and this StateMachine visit
 * https://kapta.medium.com/safe-simple-rest-api-call-in-android-with-kotlin-coroutines-lambda-ae27985f3f6e
 * https://medium.com/nerd-for-tech/safe-retrofit-calls-extension-with-kotlin-coroutines-for-android-in-2021-part-ii-fd55842951cf
 */
sealed class StateMachine<out R> {
    data class Success<out T>(val value: T) : StateMachine<T>()
    data class ApiError(
        val statusCode: Int,
        val error: ErrorResponse? = null
    ) : StateMachine<Nothing>()
    object UnknownError : StateMachine<Nothing>()
    object Finish : StateMachine<Nothing>()
    object Loading : StateMachine<Nothing>()
}
