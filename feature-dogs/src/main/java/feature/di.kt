package feature

import feature.constants.BaseUrl
import feature.data.api.DogsApiService
import feature.retrofit.BuildRetrofit
import feature.retrofit.provideOkHttpClientAuthDogs
import feature.utils.createApi
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
