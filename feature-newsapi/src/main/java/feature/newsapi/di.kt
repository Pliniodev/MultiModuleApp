package feature.newsapi

import feature.commons.utils.createApi
import feature.network.constants.BaseUrl
import feature.network.constants.InjectionTag
import feature.network.retrofit.BuildRetrofit
import feature.network.retrofit.provideOkHttpClientAuthNewsApi
import feature.newsapi.data.NewsApiGateway
import feature.newsapi.data.NewsApiInfrastructure
import feature.newsapi.domain.NewsApiService
import feature.newsapi.presentation.home.NewsApiHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val newsApiModule = module {
    single(named(InjectionTag.RETROFIT_NEWS_API)) {
        BuildRetrofit(
            apiBaseUrl = BaseUrl.newsApi,
            okHttpClient = provideOkHttpClientAuthNewsApi()
        )
    }

    single(named(InjectionTag.API_NEWS_API)) {
        createApi<NewsApiGateway>(get(named(InjectionTag.RETROFIT_NEWS_API)))
    }

    single<NewsApiService> {
        NewsApiInfrastructure(api = get(named(InjectionTag.API_NEWS_API)))
    }

    viewModel {
        NewsApiHomeViewModel(service = get())
    }
}
