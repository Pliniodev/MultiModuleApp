package feature.di

import feature.domain.usecase.ApiUseCase
import feature.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModule = module {
    factory { ApiUseCase(repository = get()) }
}

val homeModule = module {
    viewModel { HomeViewModel() }
}
