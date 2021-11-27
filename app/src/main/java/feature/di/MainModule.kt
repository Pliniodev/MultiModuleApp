package feature.di

import feature.ricky.domain.usecase.ApiUseCase
import feature.ricky.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModule = module {
    factory { ApiUseCase(repository = get()) }
}

val homeModule = module {
    viewModel { HomeViewModel() }
}
