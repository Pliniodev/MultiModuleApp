package feature.marvelapi.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import feature.commons.utils.StateMachine
import feature.commons.utils.liveResponse
import feature.commons.utils.saferequest.safeRequest
import feature.marvelapi.domain.repository.MarvelRepository
import feature.marvelapi.presentation.model.MainPresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MarvelHomeViewModel(private val repository: MarvelRepository) : ViewModel() {

    fun getCharacters(): LiveData<StateMachine<MainPresentation>> = liveResponse {
        safeRequest { repository.getCharacters() }
    }

//    private fun getCharacters() {
//        viewModelScope.launch {
//            try {
//                success.value = repository.getCharacters()
//            } catch (e: Exception) {
//                error.value = e
//            }
//        }
//    }
}
