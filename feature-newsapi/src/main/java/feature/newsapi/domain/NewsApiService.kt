package feature.newsapi.domain

import feature.newsapi.domain.model.Everything
import io.reactivex.rxjava3.core.Observable

internal interface NewsApiService {
    fun getNewsBySearch(search: String = "bitcoin"): Observable<Everything>
}
