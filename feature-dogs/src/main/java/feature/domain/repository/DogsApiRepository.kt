package feature.domain.repository

import feature.presentation.model.BreedPresentation

internal interface DogsApiRepository {
    suspend fun getBreeds(page: Int): List<BreedPresentation>
}