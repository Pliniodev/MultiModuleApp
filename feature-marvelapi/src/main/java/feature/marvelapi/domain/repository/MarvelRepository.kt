package feature.marvelapi.domain.repository

import feature.marvelapi.data.model.Someeeee
import feature.marvelapi.presentation.model.SomePresentation

interface MarvelRepository {

    suspend fun test(): SomePresentation
}