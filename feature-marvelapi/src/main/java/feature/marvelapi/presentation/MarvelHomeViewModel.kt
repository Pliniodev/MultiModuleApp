package feature.marvelapi.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import feature.marvelapi.data.model.Someeeee
import feature.marvelapi.domain.repository.MarvelRepository
import feature.marvelapi.presentation.model.SomePresentation
import kotlinx.coroutines.launch

class MarvelHomeViewModel(private val repository: MarvelRepository) : ViewModel() {

    val test = MutableLiveData<SomePresentation>()

    val error = MutableLiveData<Exception>()

    init {
        test()
    }

    private fun test() {
        viewModelScope.launch {
            try {
                test.value = repository.test()
            } catch (e: Exception) {
                error.value = e
            }
        }
    }
}