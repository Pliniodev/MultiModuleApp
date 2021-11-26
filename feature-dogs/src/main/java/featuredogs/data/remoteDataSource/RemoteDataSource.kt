package featuredogs.data.remoteDataSource

import featuredogs.domain.model.BreedDomain

internal interface RemoteDataSource {
    suspend fun getBreedsByPage(page: Int): List<BreedDomain>
}
