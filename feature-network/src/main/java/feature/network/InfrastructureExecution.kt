package feature.network

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

class InfrastructureExecution<T>(
    private val scheduler: Scheduler = Schedulers.trampoline()
) : ObservableTransformer<T, T> {

    override fun apply(upstream: Observable<T>): ObservableSource<T> =
        upstream
            .subscribeOn(scheduler)
            .compose(HandleInfrastructureErrors())
            .doOnError { Log.e("INFRASTRUCTURE_ERROR", "API integration -> Failed with ") }
            .doOnNext { Log.i("INFRASTRUCTURE_SUCCESS", "API integration -> Success") }
}
