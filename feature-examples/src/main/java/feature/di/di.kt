package feature.di

import feature.presentation.viewmodel.ExampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val exampleModule = module {
    viewModel { ExampleViewModel() }
}
