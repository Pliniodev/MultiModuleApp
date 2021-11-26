package featuredogs.domain.repository

import featuredogs.presentation.model.BreedPresentation

internal interface DogsApiRepository {
    suspend fun getBreeds(page: Int): List<BreedPresentation>
}
