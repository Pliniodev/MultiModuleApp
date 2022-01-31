package feature.marvelapi.data.remotedatasource

import feature.marvelapi.data.localdatasource.entity.CharacterEntity
import feature.marvelapi.domain.model.MainCharactersDomain

internal interface RemoteDataSource {

    suspend fun getCharactersDomain(offset: Int, name: String?): MainCharactersDomain

    suspend fun getCharacterDetailsDomain(id: Int): MainCharactersDomain

}
