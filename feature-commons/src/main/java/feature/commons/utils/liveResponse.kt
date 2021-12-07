package feature.commons.utils

import androidx.lifecycle.liveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.IO

/**
 * To understand inline, noinline e crossinline visit
 * https://medium.com/android-news/inline-noinline-crossinline-what-do-they-mean-b13f48e113c2
 */
inline fun <T> liveResponse(
    dispatcher: CoroutineDispatcher = IO,
    crossinline body: suspend () -> StateMachine<T>
) =
    liveData(dispatcher) {
        emit(StateMachine.Loading)
        val result = body()
        emit(result)
        emit(StateMachine.Finish)
    }


