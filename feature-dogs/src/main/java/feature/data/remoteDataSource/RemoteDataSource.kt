package feature.data.remoteDataSource

import feature.domain.model.BreedDomain

internal interface RemoteDataSource {
    suspend fun getBreedsByPage(page: Int): List<BreedDomain>
}
