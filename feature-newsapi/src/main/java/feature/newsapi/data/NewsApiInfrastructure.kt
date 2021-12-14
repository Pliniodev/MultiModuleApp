package feature.newsapi.data

import feature.network.InfrastructureExecution
import feature.newsapi.data.mapper.EverythingMapper
import feature.newsapi.domain.NewsApiService
import feature.newsapi.domain.model.Everything
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

internal class NewsApiInfrastructure(
    private val api: NewsApiGateway,
    private val scheduler: Scheduler = Schedulers.trampoline()
) : NewsApiService {

    private val execution by lazy { InfrastructureExecution<Everything>(scheduler = scheduler) }

    override fun getNewsBySearch(search: String): Observable<Everything> {
        return api.getNewsByQuery(search).map { EverythingMapper.toDomain(it) }
            .compose(execution)
    }
}
