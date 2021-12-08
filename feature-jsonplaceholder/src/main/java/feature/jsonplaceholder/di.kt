package feature.jsonplaceholder

import feature.commons.utils.createApi
import feature.jsonplaceholder.data.JsonPlaceHolderGateway
import feature.jsonplaceholder.data.JsonPlaceHolderInfrastructure
import feature.jsonplaceholder.domain.service.JsonPlaceHolderService
import feature.jsonplaceholder.presentation.home.JsonPlaceHolderHomeViewModel
import feature.network.constants.BaseUrl
import feature.network.constants.InjectionTag
import feature.network.retrofit.BuildRetrofit
import feature.network.retrofit.provideOkHttpClient
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val jsonPlaceHolderModule = module {
    single(named(InjectionTag.RETROFIT_JSON_PLACE_HOLDER)) {
        BuildRetrofit(
            apiBaseUrl = BaseUrl.jsonPlaceHolder,
            okHttpClient = provideOkHttpClient()
        )
    }

    single(named(InjectionTag.API_JSON_PLACE_HOLDER)) {
        createApi<JsonPlaceHolderGateway>(get(named(InjectionTag.RETROFIT_JSON_PLACE_HOLDER)))
    }

    single<JsonPlaceHolderService> {
        JsonPlaceHolderInfrastructure(api = get(named(InjectionTag.API_JSON_PLACE_HOLDER)))
    }

    viewModel {
        JsonPlaceHolderHomeViewModel(service = get())
    }
}
