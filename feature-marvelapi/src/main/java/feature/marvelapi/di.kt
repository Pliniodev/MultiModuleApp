package feature.marvelapi

import feature.commons.utils.createApi
import feature.marvelapi.data.api.MarvelApi
import feature.marvelapi.data.localdatasource.database.provideDao
import feature.marvelapi.data.localdatasource.database.provideDataBase
import feature.marvelapi.data.remotedatasource.RemoteDataSource
import feature.marvelapi.data.remotedatasource.RemoteDataSourceImpl
import feature.marvelapi.domain.repository.MarvelRepository
import feature.marvelapi.domain.repository.MarvelRepositoryImpl
import feature.marvelapi.presentation.home.viewmodel.CharacterDetailsViewModel
import feature.marvelapi.presentation.home.viewmodel.MarvelHomeViewModel
import feature.marvelapi.presentation.home.viewmodel.SeriesViewModel
import feature.network.constants.BaseUrl
import feature.network.constants.InjectionTag
import feature.network.retrofit.BuildRetrofit
import feature.network.retrofit.provideOkHttpClientMarvelApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module


val marvelModules = mutableListOf<Module>()

private val networkModule = module {
    single(named(InjectionTag.RETROFIT_MARVEL_API)) {
        BuildRetrofit(
            apiBaseUrl = BaseUrl.marvelApi,
            okHttpClient = provideOkHttpClientMarvelApi()
        )
    }

    single(named(InjectionTag.API_MARVEL_API)) {
        createApi<MarvelApi>(get(named(InjectionTag.RETROFIT_MARVEL_API)))
    }

marvelModules.add(this)

}

private val dataBaseModule = module {

    single { provideDataBase(get()) }

    single { provideDao(get()) }
    marvelModules.add(this)
}

private val viewModelModule = module {

    viewModel { MarvelHomeViewModel(repository = get()) }
    viewModel { SeriesViewModel(repository = get()) }
    viewModel { CharacterDetailsViewModel(repository = get()) }
    marvelModules.add(this)
}

private val repositoryModule = module {

    single<RemoteDataSource> { RemoteDataSourceImpl(api = get(named(InjectionTag.API_MARVEL_API))) }

    single<MarvelRepository> { MarvelRepositoryImpl(remoteDataSource = get()) }
    marvelModules.add(this)
}



