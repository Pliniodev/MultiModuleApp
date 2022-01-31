package feature.marvelapi

import androidx.room.Room
import feature.commons.utils.createApi
import feature.marvelapi.data.api.MarvelApi
import feature.marvelapi.data.localdatasource.LocalDataSource
import feature.marvelapi.data.localdatasource.LocalDataSourceImpl
import feature.marvelapi.data.localdatasource.database.MarvelDataBase
import feature.marvelapi.data.localdatasource.database.provideDao
import feature.marvelapi.data.remotedatasource.RemoteDataSource
import feature.marvelapi.data.remotedatasource.RemoteDataSourceImpl
import feature.marvelapi.domain.repository.MarvelRepository
import feature.marvelapi.domain.repository.MarvelRepositoryImpl
import feature.marvelapi.presentation.viewmodel.CharacterDetailsViewModel
import feature.marvelapi.presentation.viewmodel.DataBaseViewModel
import feature.marvelapi.presentation.viewmodel.MarvelHomeViewModel
import feature.marvelapi.utils.Constants
import feature.network.constants.BaseUrl
import feature.network.constants.InjectionTag
import feature.network.retrofit.BuildRetrofit
import feature.network.retrofit.provideOkHttpClientMarvelApi
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val marvelModule = module {

    /**
     * network
     */

    single(named(InjectionTag.RETROFIT_MARVEL_API)) {
        BuildRetrofit(
            apiBaseUrl = BaseUrl.marvelApi,
            okHttpClient = provideOkHttpClientMarvelApi()
        )
    }

    single(named(InjectionTag.API_MARVEL_API)) {
        createApi<MarvelApi>(get(named(InjectionTag.RETROFIT_MARVEL_API)))
    }

    /**
     * Data base
     */

    single {
        Room.databaseBuilder(
            androidApplication(),
            MarvelDataBase::class.java,
            Constants.ROOM_DATABASE_NAME
        ).build()
    }

    single(named(InjectionTag.PROVIDE_DAO)) { provideDao(db = get()) }

    /**
     * Data source
     */

    single<RemoteDataSource> {
        RemoteDataSourceImpl(
            api = get(named(InjectionTag.API_MARVEL_API))
        )
    }

    single<LocalDataSource> { LocalDataSourceImpl(get(named(InjectionTag.PROVIDE_DAO))) }

    /**
     * Repository
     */

    single<MarvelRepository> {
        MarvelRepositoryImpl(
            remoteDataSource = get(),
            localDataSource = get()
        )
    }

    /**
     * VewModel
     */

    viewModel { MarvelHomeViewModel(repository = get()) }
    viewModel { CharacterDetailsViewModel(repository = get()) }
    viewModel { DataBaseViewModel(repository = get()) }
}
