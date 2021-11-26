package featuredogs.data.remoteDataSource

import featuredogs.data.api.DogsApiService
import featuredogs.data.mapper.BreedsMapper
import featuredogs.domain.model.BreedDomain

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
