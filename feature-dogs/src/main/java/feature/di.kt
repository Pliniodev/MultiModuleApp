package feature

import feature.data.api.DogsApiService
import feature.utils.createApi
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkDogsModule = module {
    single (named("apiDogs")){ createApi<DogsApiService>(get(named("retrofitDogs"))) }
}
