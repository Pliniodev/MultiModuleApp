package feature.app.di

import feature.app.presentation.home.HomeViewModel
import feature.ricky.domain.usecase.ApiUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModule = module {
    factory { ApiUseCase(repository = get()) }
}

val homeModule = module {
    viewModel { HomeViewModel() }
}
