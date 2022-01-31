package feature.marvelapi.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import feature.commons.utils.StateMachine
import feature.commons.utils.liveResponse
import feature.commons.utils.saferequest.safeRequest
import feature.marvelapi.data.localdatasource.entity.CharacterEntity
import feature.marvelapi.domain.repository.MarvelRepository

internal class DataBaseViewModel(private val repository: MarvelRepository) : ViewModel() {

    fun getCachedDAta(): LiveData<StateMachine<List<CharacterEntity>>> = liveResponse {
        safeRequest { repository.getAll() }
    }
}