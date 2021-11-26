package feature.data.repository

import feature.data.remoteDataSource.RemoteDataSource
import feature.domain.mapper.BreedsDomainMapper
import feature.domain.repository.DogsApiRepository
import feature.presentation.model.BreedPresentation

internal class DogsApiRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): DogsApiRepository {
    override suspend fun getBreeds(page: Int): List<BreedPresentation> {
        return BreedsDomainMapper.toBreedsPresentation(remoteDataSource.getBreedsByPage(page))
    }
}