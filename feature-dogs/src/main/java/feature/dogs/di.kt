package feature.dogs

import feature.commons.constants.BaseUrl
import feature.commons.constants.InjectionTag
import feature.commons.retrofit.BuildRetrofit
import feature.commons.retrofit.provideOkHttpClientAuthDogs
import feature.commons.utils.createApi
import feature.dogs.data.api.DogsApiService
import feature.dogs.data.remoteDataSource.RemoteDataSource
import feature.dogs.data.remoteDataSource.RemoteDataSourceImpl
import feature.dogs.data.repository.DogsApiRepositoryImpl
import feature.dogs.domain.repository.DogsApiRepository
import feature.dogs.presentation.home.DogsHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dogsModule = module {
    viewModel {
        DogsHomeViewModel(api = get())
    }
}

val networkDogsModule = module {
    single(named(InjectionTag.RETROFIT_RICKY)) {
        BuildRetrofit(
            apiBaseUrl = BaseUrl.dogs,
            okHttpClient = provideOkHttpClientAuthDogs()
        )
    }
    single(named(InjectionTag.API_RICKY)) {
        createApi<DogsApiService>(get(named(InjectionTag.RETROFIT_RICKY)))
    }
}

val dataDogsModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(api = get(named(InjectionTag.API_RICKY))) }
    single<DogsApiRepository> { DogsApiRepositoryImpl(remoteDataSource = get()) }
}
