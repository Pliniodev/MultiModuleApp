package feature.ricky.data.remoteDataSource

import feature.ricky.data.api.DogsApiService
import feature.ricky.data.mapper.BreedsMapper
import feature.ricky.domain.model.BreedDomain

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
