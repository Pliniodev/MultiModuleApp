package feature.dogs.domain.repository

import feature.dogs.presentation.model.BreedPresentation

internal interface DogsApiRepository {
    suspend fun getBreeds(page: Int): List<BreedPresentation>
}
