package feature

import feature.constants.BaseUrl
import feature.data.api.DogsApiService
import feature.data.remoteDataSource.RemoteDataSource
import feature.data.remoteDataSource.RemoteDataSourceImpl
import feature.data.repository.DogsApiRepositoryImpl
import feature.domain.repository.DogsApiRepository
import feature.presentation.home.DogsHomeViewModel
import feature.retrofit.BuildRetrofit
import feature.retrofit.provideOkHttpClientAuthDogs
import feature.utils.createApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkDogsModule = module {
    single(named("retrofitDogs")) {
        BuildRetrofit(
            apiBaseUrl = BaseUrl.dogs,
            okHttpClient = provideOkHttpClientAuthDogs()
        )
    }
    single(named("apiDogs")) { createApi<DogsApiService>(get(named("retrofitDogs"))) }
}

val dogsModule = module {
    viewModel {
        DogsHomeViewModel(api = get())
    }
}

val dataDogsModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(api = get(named("apiDogs"))) }
    single<DogsApiRepository> { DogsApiRepositoryImpl(remoteDataSource = get()) }
}