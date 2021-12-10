package feature.newsapi.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import feature.newsapi.domain.NewsApiService
import feature.newsapi.domain.model.Everything
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

internal class NewsApiHomeViewModel(
    private val service: NewsApiService
) : ViewModel() {
    private val _newsByEverything = MutableLiveData<Everything>()
    val newsByEverything: LiveData<Everything> = _newsByEverything

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> = _errorMsg

    fun makeApiCall() {
        service.getNewsBySearch()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getNews())
    }

    private fun getNews(): Observer<Everything> {
        return object : Observer<Everything> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(everything: Everything) {
                _newsByEverything.postValue(everything)
            }

            override fun onError(e: Throwable) {
                _errorMsg.postValue("Deu ruim no rx!, $e")
            }

            override fun onComplete() {
            }
        }
    }
}
