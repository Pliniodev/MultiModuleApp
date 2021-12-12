package feature.marvelapi.domain.repository

import feature.marvelapi.presentation.model.MainPresentation

interface MarvelRepository {

    suspend fun getCharacters(): MainPresentation
}