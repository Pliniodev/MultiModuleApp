package feature.marvelapi.data.remotedatasource

import feature.marvelapi.domain.model.MainDomain

interface RemoteDataSource {

    suspend fun getCharactersDomain(): MainDomain
}
