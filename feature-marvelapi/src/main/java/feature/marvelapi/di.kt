package feature.marvelapi

import feature.commons.utils.createApi
import feature.marvelapi.data.api.MarvelApi
import feature.marvelapi.data.remotedatasource.RemoteDataSource
import feature.marvelapi.data.remotedatasource.RemoteDataSourceImpl
import feature.marvelapi.data.repository.MarvelRepositoryImpl
import feature.marvelapi.domain.repository.MarvelRepository
import feature.marvelapi.presentation.MarvelHomeViewModel
import feature.network.constants.BaseUrl
import feature.network.constants.InjectionTag
import feature.network.retrofit.BuildRetrofit
import feature.network.retrofit.provideOkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val marvelModule = module {
    single(named(InjectionTag.RETROFIT_MARVEL_API)) {
        BuildRetrofit(
            apiBaseUrl = BaseUrl.marvelApi,
            okHttpClient = provideOkHttpClient()
        )
    }

    single(named(InjectionTag.API_MARVEL_API)) {
        createApi<MarvelApi>(get(named(InjectionTag.RETROFIT_MARVEL_API)))
    }

    single<RemoteDataSource>{RemoteDataSourceImpl(api = get(named(InjectionTag.API_MARVEL_API)))}

    single<MarvelRepository> {MarvelRepositoryImpl(remoteDataSource = get())  }

    viewModel { MarvelHomeViewModel(repository = get()) }

}
