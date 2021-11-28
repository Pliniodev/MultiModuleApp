package feature.ricky

import feature.network.constants.BaseUrl
import feature.network.constants.InjectionTag
import feature.network.retrofit.BuildRetrofit
import feature.network.retrofit.provideOkHttpClient
import feature.commons.utils.createApi
import feature.ricky.data.remote.api.ApiService
import feature.ricky.data.remote.remotedatasource.RemoteDataSourceRicky
import feature.ricky.data.remote.remotedatasource.RemoteDatasourceImpl
import feature.ricky.data.remote.repository.ApiRepositoryImpl
import feature.ricky.domain.repository.ApiRepository
import feature.ricky.presentation.home.RickyHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val rickyAndMortyModule = module {

    single(named(InjectionTag.RETROFIT_RICKY)) {
        BuildRetrofit(
            apiBaseUrl = BaseUrl.rickyAndMorty,
            okHttpClient = provideOkHttpClient()
        )
    }

    single(named(InjectionTag.API_RICKY)) {
        createApi<ApiService>(get(named(InjectionTag.RETROFIT_RICKY)))
    }

    single<RemoteDataSourceRicky> { RemoteDatasourceImpl(api = get(named(InjectionTag.API_RICKY))) }

    single<ApiRepository> { ApiRepositoryImpl(remoteDataSource = get()) }

    viewModel {
        RickyHomeViewModel(api = get())
    }
}
