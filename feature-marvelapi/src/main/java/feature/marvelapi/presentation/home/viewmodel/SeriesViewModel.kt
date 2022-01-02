package feature.marvelapi.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import feature.commons.utils.StateMachine
import feature.commons.utils.liveResponse
import feature.commons.utils.saferequest.safeRequest
import feature.marvelapi.domain.repository.MarvelRepository
import feature.marvelapi.presentation.model.MainSeriesPresentation

internal class SeriesViewModel(private val repository: MarvelRepository) : ViewModel() {

    fun getSeries(): LiveData<StateMachine<MainSeriesPresentation>> = liveResponse {
        safeRequest { repository.getSeries() }
    }
}