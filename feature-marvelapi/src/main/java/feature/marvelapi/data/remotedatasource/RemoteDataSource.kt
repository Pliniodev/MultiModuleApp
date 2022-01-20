package feature.marvelapi.data.remotedatasource

import feature.marvelapi.domain.model.MainCharactersDomain
import feature.marvelapi.domain.model.MainSeriesDomain

internal interface RemoteDataSource {

    suspend fun getCharactersDomain(offset: Int, name: String?): MainCharactersDomain
}
