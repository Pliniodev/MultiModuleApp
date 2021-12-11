package feature.marvelapi.data.remotedatasource

import feature.marvelapi.domain.model.SomeDomain

interface RemoteDataSource {

    suspend fun getSome(): SomeDomain
}