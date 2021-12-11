package feature.marvelapi

import feature.commons.utils.createApi
import feature.marvelapi.data.api.MarvelApi
import feature.marvelapi.data.repository.MarvelRepository
import feature.marvelapi.data.repository.MarvelRepositoryImpl
import feature.marvelapi.presentation.MarvelHomeViewModel
import feature.network.constants.BaseUrl
import feature.network.constants.InjectionTag
import feature.network.retrofit.BuildRetrofit
import feature.network.retrofit.provideOkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val marvelModule = module {
    single(named(InjectionTag.RETROFIT_RICKY)) {
        BuildRetrofit(
            apiBaseUrl = BaseUrl.marvelApi,
            okHttpClient = provideOkHttpClient()
        )
    }

    single(named(InjectionTag.API_MARVEL_API)) {
        createApi<MarvelApi>(get(named(InjectionTag.RETROFIT_MARVEL_API)))
    }

//    single<RemoteDataSource> {
//        RemoteDataSourceImpl(
//            api = get(named(InjectionTag.API_RICKY))
//        )
//    }

    single<MarvelRepository> { MarvelRepositoryImpl(get()) }

    viewModel { MarvelHomeViewModel(get()) }
}
