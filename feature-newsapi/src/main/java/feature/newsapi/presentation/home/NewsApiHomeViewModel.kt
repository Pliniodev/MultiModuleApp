package feature.newsapi.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import feature.newsapi.domain.NewsApiService
import feature.newsapi.domain.model.Article
import feature.newsapi.domain.model.Everything
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers

internal class NewsApiHomeViewModel(
    private val service: NewsApiService
) : ViewModel() {

    fun getEverything() : Observable<Everything> {
        return service.getNewsBySearch()
    }
}
