package feature.marvelapi.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import feature.marvelapi.domain.repository.MarvelRepository
import feature.marvelapi.presentation.model.MainPresentation
import kotlinx.coroutines.launch

class MarvelHomeViewModel(private val repository: MarvelRepository) : ViewModel() {

    val test = MutableLiveData<MainPresentation>()

    val error = MutableLiveData<Exception>()

    init {
        test()
    }

    private fun test() {
        viewModelScope.launch {
            try {
                test.value = repository.getCharacters()
            } catch (e: Exception) {
                error.value = e
            }
        }
    }
}