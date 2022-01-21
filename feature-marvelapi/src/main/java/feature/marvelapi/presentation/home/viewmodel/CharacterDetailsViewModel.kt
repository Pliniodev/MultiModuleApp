package feature.marvelapi.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import feature.commons.utils.StateMachine
import feature.commons.utils.liveResponse
import feature.commons.utils.saferequest.safeRequest
import feature.marvelapi.domain.repository.MarvelRepository
import feature.marvelapi.presentation.model.CharactersPresentation

internal class CharacterDetailsViewModel(private val repository: MarvelRepository): ViewModel() {

    fun getCharacterDetails(id: Int): LiveData<StateMachine<CharactersPresentation>> = liveResponse{
        safeRequest { repository.getCharacterDetails(id).data.results.first() }
    }
}