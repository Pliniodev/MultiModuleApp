package feature.newsapi.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import feature.newsapi.domain.NewsApiService
import feature.newsapi.domain.model.Article
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

internal class NewsApiHomeViewModel(
    private val service: NewsApiService
) : ViewModel() {
    private val _articles = MutableLiveData<List<Article>?>()
    val articles: LiveData<List<Article>?> = _articles

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMsg = MutableLiveData<String>()
    val errorMsg: LiveData<String> = _errorMsg

    fun makeApiCall() {
        service.getNewsBySearch()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { everything -> _articles.postValue(everything.articles) },
                onComplete = { _isLoading.postValue(false) },
                onError = { throwable ->
                    Log.e("MAKE API CALL", "Error: ${throwable.message}")
                }
            )
    }
}
