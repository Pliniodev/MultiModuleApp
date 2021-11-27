package feature.ricky.data.repository

import feature.ricky.data.remoteDataSource.RemoteDataSource
import feature.ricky.domain.mapper.BreedsDomainMapper
import feature.ricky.domain.repository.DogsApiRepository
import feature.ricky.presentation.model.BreedPresentation

internal class DogsApiRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : DogsApiRepository {
    override suspend fun getBreeds(page: Int): List<BreedPresentation> {
        return BreedsDomainMapper.toBreedsPresentation(remoteDataSource.getBreedsByPage(page))
    }
}
