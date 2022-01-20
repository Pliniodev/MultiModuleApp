package feature.marvelapi.data.remotedatasource

import feature.marvelapi.domain.model.MainCharactersDomain

internal interface RemoteDataSource {

    suspend fun getCharactersDomain(offset: Int, name: String?): MainCharactersDomain
}
