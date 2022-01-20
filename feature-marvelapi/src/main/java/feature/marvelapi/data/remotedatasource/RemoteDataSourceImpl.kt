package feature.marvelapi.data.remotedatasource

import feature.marvelapi.data.api.MarvelApi
import feature.marvelapi.data.mapper.MapperCharactersResponse
import feature.marvelapi.domain.model.MainCharactersDomain
import feature.marvelapi.domain.model.MainSeriesDomain

internal class RemoteDataSourceImpl(
    private val api: MarvelApi
) : RemoteDataSource {

    override suspend fun getCharactersDomain(offset: Int, name: String?): MainCharactersDomain {
        return MapperCharactersResponse.toDomain(api.getCharacters(offset, name))
    }
}
