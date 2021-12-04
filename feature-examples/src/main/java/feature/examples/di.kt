package feature.examples

import feature.examples.recyclerview.presentation.viewmodel.ExampleRecyclerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val exampleModule = module {
    viewModel { ExampleRecyclerViewModel() }
}
