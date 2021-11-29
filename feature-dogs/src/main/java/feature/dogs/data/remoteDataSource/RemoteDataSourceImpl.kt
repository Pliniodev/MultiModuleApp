package feature.dogs.data.remoteDataSource

import feature.dogs.data.api.DogsApiService
import feature.dogs.data.mapper.BreedsMapper
import feature.dogs.domain.model.BreedDomain

internal class RemoteDataSourceImpl(
    private val api: DogsApiService
) : RemoteDataSource {
    override suspend fun getBreedsByPage(page: Int): List<BreedDomain> {
        return BreedsMapper.toBreedsDomain(api.getBreedsByPage(page, FIFTY_BREEDS))
    }

    companion object {
        const val FIFTY_BREEDS = 50
    }
}
