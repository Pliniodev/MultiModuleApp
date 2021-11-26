package featuredogs

import feature.constants.BaseUrl
import feature.constants.InjectionTag
import feature.retrofit.BuildRetrofit
import feature.retrofit.provideOkHttpClientAuthDogs
import feature.utils.createApi
import featuredogs.data.api.DogsApiService
import featuredogs.data.remoteDataSource.RemoteDataSource
import featuredogs.data.remoteDataSource.RemoteDataSourceImpl
import featuredogs.data.repository.DogsApiRepositoryImpl
import featuredogs.domain.repository.DogsApiRepository
import featuredogs.presentation.home.DogsHomeViewModel
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
