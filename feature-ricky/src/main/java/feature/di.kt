package feature

import feature.data.remote.api.ApiService
import feature.data.remote.remotedatasource.RemoteDataSource
import feature.data.remote.remotedatasource.RemoteDatasourceImpl
import feature.data.remote.repository.ApiRepositoryImpl
import feature.domain.repository.ApiRepository
import feature.presentation.home.RickyAndMortyHomeViewModel
import feature.utils.createApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val rickyAndMortyModule = module {
    viewModel {
        RickyAndMortyHomeViewModel(api = get())
    }
}

val networkRickyAndMortyModule = module {
    single (named("apiRicky")){ createApi<ApiService>(get(named("retrofitRicky"))) }
}

val dataRickyAndMortyModule = module {
    single<RemoteDataSource> { RemoteDatasourceImpl(api = get(named("apiRicky"))) }
    single<ApiRepository> { ApiRepositoryImpl(remoteDataSource = get()) }
}