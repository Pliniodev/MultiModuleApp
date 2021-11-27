package feature.ricky.data.remoteDataSource

import feature.ricky.domain.model.BreedDomain

internal interface RemoteDataSource {
    suspend fun getBreedsByPage(page: Int): List<BreedDomain>
}
