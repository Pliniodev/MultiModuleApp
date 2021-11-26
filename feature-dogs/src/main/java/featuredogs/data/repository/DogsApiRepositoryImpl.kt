package featuredogs.data.repository

import featuredogs.data.remoteDataSource.RemoteDataSource
import featuredogs.domain.mapper.BreedsDomainMapper
import featuredogs.domain.repository.DogsApiRepository
import featuredogs.presentation.model.BreedPresentation

internal class DogsApiRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : DogsApiRepository {
    override suspend fun getBreeds(page: Int): List<BreedPresentation> {
        return BreedsDomainMapper.toBreedsPresentation(remoteDataSource.getBreedsByPage(page))
    }
}
