package feature.marvelapi.data.remotedatasource

import feature.marvelapi.data.api.MarvelApi
import feature.marvelapi.data.mapper.CharactersResponseToDomain
import feature.marvelapi.domain.model.MainDomain

class RemoteDataSourceImpl(private val api: MarvelApi) : RemoteDataSource {

    override suspend fun getCharactersDomain(): MainDomain {
        return CharactersResponseToDomain.responseToDomain(api.getCharacters())
    }
}
