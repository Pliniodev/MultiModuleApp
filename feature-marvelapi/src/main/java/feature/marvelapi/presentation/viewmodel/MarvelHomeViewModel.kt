package feature.marvelapi.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import feature.commons.utils.StateMachine
import feature.commons.utils.liveResponse
import feature.commons.utils.saferequest.safeRequest
import feature.marvelapi.domain.repository.MarvelRepository
import feature.marvelapi.presentation.model.MainPresentation

internal class MarvelHomeViewModel(private val repository: MarvelRepository) : ViewModel() {

    fun getCharacters(offSet: Int, name: String?): LiveData<StateMachine<MainPresentation>> = liveResponse {
        safeRequest { repository.getCharacters(offSet, name) }
    }
}
