package feature.ricky

import feature.commons.constants.BaseUrl
import feature.commons.constants.InjectionTag
import feature.commons.retrofit.BuildRetrofit
import feature.commons.retrofit.provideOkHttpClient
import feature.commons.utils.createApi
import feature.dogs.data.local.localdatasource.LocalDataSource
import feature.dogs.data.local.localdatasource.LocalDataSourceImpl
import feature.dogs.data.local.provideDB
import feature.dogs.data.local.provideStepDAO
import feature.dogs.data.remote.api.ApiService
import feature.dogs.data.remote.remotedatasource.RemoteDataSourceRicky
import feature.dogs.data.remote.remotedatasource.RemoteDatasourceImpl
import feature.dogs.data.remote.repository.ApiRepositoryImpl
import feature.dogs.domain.repository.ApiRepository
import feature.dogs.presentation.home.RickyHomeViewModel
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
