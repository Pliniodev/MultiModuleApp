package feature.commons.utils

sealed class StateMachine<out R> {
    data class Success<out T>(val value: T) : StateMachine<T>()
    data class Failure(val error: Throwable) : StateMachine<Nothing>()
    object Finish : StateMachine<Nothing>()
    object Loading : StateMachine<Nothing>()
}
