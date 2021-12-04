package feature.examples

import feature.commons.utils.createApi
import feature.examples.examplemainhome.presentation.ExampleMainHomeViewModel
import feature.examples.recyclerview.presentation.viewmodel.ExampleRecyclerViewModel
import feature.examples.apirequest.data.JsonPlaceHolderGateway
import feature.examples.apirequest.data.JsonPlaceHolderInfrastructure
import feature.examples.apirequest.domain.service.JsonPlaceHolderService
import feature.examples.apirequest.presentation.home.ExampleApiRequestHomeViewModel
import feature.network.constants.BaseUrl
import feature.network.constants.InjectionTag
import feature.network.retrofit.BuildRetrofit
import feature.network.retrofit.provideOkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val exampleModule = module {
    viewModel { ExampleRecyclerViewModel() }
    viewModel { ExampleMainHomeViewModel() }
}

val apiRequestJsonPlaceHolderModule = module {
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
        ExampleApiRequestHomeViewModel(service = get())
    }
}
