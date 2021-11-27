package feature.dogs.data.remoteDataSource

import feature.dogs.domain.model.BreedDomain

internal interface RemoteDataSource {
    suspend fun getBreedsByPage(page: Int): List<BreedDomain>
}
