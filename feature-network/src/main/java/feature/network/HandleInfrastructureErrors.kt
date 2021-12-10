package feature.network

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.core.ObservableTransformer

internal class HandleInfrastructureErrors<T> : ObservableTransformer<T, T> {

    override fun apply(upstream: Observable<T>): ObservableSource<T> =
        upstream.onErrorResumeNext { error: Throwable ->
            Observable.error(error)
        }
}
