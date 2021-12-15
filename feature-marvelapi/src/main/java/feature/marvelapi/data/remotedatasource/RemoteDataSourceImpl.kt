package feature.marvelapi.data.remotedatasource

import feature.marvelapi.data.api.MarvelApi
import feature.marvelapi.data.mapper.MapperCharactersResponse
import feature.marvelapi.domain.model.MainDomain

internal class RemoteDataSourceImpl(private val api: MarvelApi) : RemoteDataSource {

    override suspend fun getCharactersDomain(): MainDomain {
        return MapperCharactersResponse.toDomain(api.getCharacters())
    }
}
