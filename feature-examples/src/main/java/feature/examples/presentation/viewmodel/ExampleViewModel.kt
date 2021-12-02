package feature.examples.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import feature.examples.presentation.model.ExampleModel

/**
 * This class viewModel, has the responsibility to pass data to the views, making the view more
 * dump possible. This is necessary because viewModels don't follow the lifeCycle of the views,
 * like onPause and onStop, but it lives while the view is alive.
 */

/**
 * ATTENTION - Using the koin for dependency injection, you need to declare your viewModel in the
 * koin module, currently localized in: app-home -> java -> feature -> di -> di.kt
 */
class ExampleViewModel : ViewModel() {
    /**
     * Here we have a simple backing field. Inside of the class we do all the changes on the data,
     * so we have access to getters/setters (private val _exampleList), and we just pass a getter
     * to the view.
     */
    private val _exampleList = MutableLiveData<List<ExampleModel>>()
    val exampleList: LiveData<List<ExampleModel>> = _exampleList

    /**
     * This init method means that every time this class is called, it will set the data to the
     * objects.
     */
    init {
        /**
         *  Just an example list
         */
        _exampleList.value = listOf(
            ExampleModel("Usando o Navigator"),
            ExampleModel("example 2"),
            ExampleModel("example 3"),
        )
    }
}
