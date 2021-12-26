package feature.marvelapi.data.remotedatasource

import feature.marvelapi.domain.model.MainDomain

internal interface RemoteDataSource {

    suspend fun getCharactersDomain(offset: Int, name: String?): MainDomain
}
