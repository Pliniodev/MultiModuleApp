package feature.commons.utils

import androidx.lifecycle.liveData

inline fun <T> liveResponse(
    crossinline body: suspend () -> StateMachine<T>
) =
    liveData {
        emit(StateMachine.Loading)
        val result = body()
        emit(result)
        emit(StateMachine.Finish)
    }
