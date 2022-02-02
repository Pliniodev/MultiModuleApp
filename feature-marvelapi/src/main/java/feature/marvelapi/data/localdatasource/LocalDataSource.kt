package feature.marvelapi.data.localdatasource

import feature.marvelapi.data.localdatasource.entity.CharacterEntity

internal interface LocalDataSource {

    suspend fun saveCharacterOnDB(character: CharacterEntity)

    suspend fun getAll(): List<CharacterEntity>

    suspend fun consultCharacter(id: Long): CharacterEntity?

}