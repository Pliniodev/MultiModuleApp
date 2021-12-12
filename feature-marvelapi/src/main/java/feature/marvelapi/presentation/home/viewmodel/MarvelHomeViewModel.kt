package feature.marvelapi.presentation.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import feature.marvelapi.domain.repository.MarvelRepository
import feature.marvelapi.presentation.model.MainPresentation
import kotlinx.coroutines.launch

class MarvelHomeViewModel(private val repository: MarvelRepository) : ViewModel() {

    val success = MutableLiveData<MainPresentation>()

    val error = MutableLiveData<Exception>()

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            try {
                success.value = repository.getCharacters()
            } catch (e: Exception) {
                error.value = e
            }
        }
    }
}