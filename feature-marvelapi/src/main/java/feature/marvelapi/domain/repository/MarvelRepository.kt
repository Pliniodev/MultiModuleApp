package feature.marvelapi.domain.repository

import feature.marvelapi.presentation.model.MainPresentation
import feature.marvelapi.presentation.model.MainSeriesPresentation

internal interface MarvelRepository {

    suspend fun getCharacters(offset: Int, name: String?): MainPresentation

    suspend fun getSeries(): MainSeriesPresentation
}
