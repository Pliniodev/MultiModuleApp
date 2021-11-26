package feature

import feature.constants.BaseUrl
import feature.constants.InjectionTag
import feature.data.local.localdatasource.LocalDataSource
import feature.data.local.localdatasource.LocalDataSourceImpl
import feature.data.local.provideDB
import feature.data.local.provideStepDAO
import feature.data.remote.api.ApiService
import feature.data.remote.remotedatasource.RemoteDataSourceRicky
import feature.data.remote.remotedatasource.RemoteDatasourceImpl
import feature.data.remote.repository.ApiRepositoryImpl
import feature.domain.repository.ApiRepository
import feature.presentation.home.RickyHomeViewModel
import feature.retrofit.BuildRetrofit
import feature.retrofit.provideOkHttpClient
import feature.utils.createApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val rickyAndMortyModule = module {
    viewModel {
        RickyHomeViewModel(api = get())
    }
}

val networkRickyAndMortyModule = module {
    single(named(InjectionTag.RETROFIT_RICKY)) {
        BuildRetrofit(
            apiBaseUrl = BaseUrl.rickyAndMorty,
            okHttpClient = provideOkHttpClient()
        )
    }
    single(named(InjectionTag.API_RICKY)) {
        createApi<ApiService>(get(named(InjectionTag.RETROFIT_RICKY)))
    }
}

val dataRickyAndMortyModule = module {
    single<RemoteDataSourceRicky> { RemoteDatasourceImpl(api = get(named(InjectionTag.API_RICKY))) }
    single<ApiRepository> { ApiRepositoryImpl(remoteDataSource = get()) }
}

val databaseModule = module {
    single { provideDB(application = get()) }
    single { provideStepDAO(database = get()) }
}

val dataModule = module {
    factory<LocalDataSource> { LocalDataSourceImpl(db = get()) }
}
