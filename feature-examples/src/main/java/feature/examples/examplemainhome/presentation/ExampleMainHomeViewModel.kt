package feature.examples.examplemainhome.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import feature.examples.examplemainhome.ExampleFlag
import feature.examples.examplemainhome.ExamplesMainPresentation

internal class ExampleMainHomeViewModel : ViewModel() {
    private val _examples = MutableLiveData<List<ExamplesMainPresentation>>()
    val examples: LiveData<List<ExamplesMainPresentation>> = _examples

    fun getExamples() {
        val examples = mutableListOf<ExamplesMainPresentation>()
        ExampleFlag.values().map {
            examples.add(ExamplesMainPresentation(it))
        }
        _examples.value = examples
    }
}
