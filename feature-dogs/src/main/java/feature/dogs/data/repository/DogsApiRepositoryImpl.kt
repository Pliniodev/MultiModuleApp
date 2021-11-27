package feature.dogs.data.repository

import feature.dogs.data.remoteDataSource.RemoteDataSource
import feature.dogs.domain.mapper.BreedsDomainMapper
import feature.dogs.domain.repository.DogsApiRepository
import feature.dogs.presentation.model.BreedPresentation

internal class DogsApiRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : DogsApiRepository {
    override suspend fun getBreeds(page: Int): List<BreedPresentation> {
        return BreedsDomainMapper.toBreedsPresentation(remoteDataSource.getBreedsByPage(page))
    }
}
