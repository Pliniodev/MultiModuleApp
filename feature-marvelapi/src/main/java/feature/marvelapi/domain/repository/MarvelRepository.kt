package feature.marvelapi.domain.repository

import feature.marvelapi.presentation.model.MainPresentation

internal interface MarvelRepository {

    suspend fun getCharacters(offset : Int): MainPresentation
}
