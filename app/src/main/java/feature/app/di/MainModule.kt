package feature.app.di

import feature.app.presentation.home.MainHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainHomeModule = module {
    viewModel { MainHomeViewModel() }
}
