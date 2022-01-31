package feature.marvelapi.data.localdatasource

import feature.marvelapi.data.localdatasource.dao.CharactersDao
import feature.marvelapi.data.localdatasource.entity.CharacterEntity

class LocalDataSourceImpl(private val dao: CharactersDao): LocalDataSource {

    override suspend fun saveCharacterOnDB(character: CharacterEntity) {
        dao.insertCharacter(character)
    }

    override suspend fun getAll(): List<CharacterEntity> {
        return dao.getAll()
    }
}