package feature.marvelapi.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import feature.marvelapi.domain.repository.MarvelRepository

internal class SeriesViewModel(private val repository: MarvelRepository) : ViewModel()
