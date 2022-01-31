package feature.marvelapi.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import feature.commons.utils.StateMachine
import feature.commons.utils.liveResponse
import feature.commons.utils.saferequest.safeRequest
import feature.marvelapi.data.localdatasource.entity.CharacterEntity
import feature.marvelapi.domain.repository.MarvelRepository
import feature.marvelapi.presentation.model.CharactersPresentation
import kotlinx.coroutines.launch

internal class CharacterDetailsViewModel(private val repository: MarvelRepository) : ViewModel() {

    fun getCharacterDetails(id: Int): LiveData<StateMachine<CharactersPresentation>> = liveResponse {
        safeRequest { repository.getCharacterDetails(id).data.results.first() }
    }

    fun saveCharacterOnDB(character: CharacterEntity){
        viewModelScope.launch {
            repository.saveCharacterOnDB(character)
        }
    }
}
