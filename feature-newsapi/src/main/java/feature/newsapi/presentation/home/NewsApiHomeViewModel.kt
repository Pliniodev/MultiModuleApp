package feature.newsapi.presentation.home

import androidx.lifecycle.ViewModel
import feature.newsapi.domain.NewsApiService
import feature.newsapi.domain.model.Everything
import io.reactivex.rxjava3.core.Observable

internal class NewsApiHomeViewModel(
    private val service: NewsApiService
) : ViewModel() {

    fun getEverything(): Observable<Everything> {
        return service.getNewsBySearch()
    }
}
