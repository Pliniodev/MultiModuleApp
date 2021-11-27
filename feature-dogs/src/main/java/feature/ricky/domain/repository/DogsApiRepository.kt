package feature.ricky.domain.repository

import feature.ricky.presentation.model.BreedPresentation

internal interface DogsApiRepository {
    suspend fun getBreeds(page: Int): List<BreedPresentation>
}
