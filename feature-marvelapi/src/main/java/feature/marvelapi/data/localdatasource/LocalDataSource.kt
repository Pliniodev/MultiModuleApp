package feature.marvelapi.data.localdatasource

import feature.marvelapi.data.localdatasource.entity.CharacterEntity

interface LocalDataSource {

    suspend fun saveCharacterOnDB(character: CharacterEntity)

}