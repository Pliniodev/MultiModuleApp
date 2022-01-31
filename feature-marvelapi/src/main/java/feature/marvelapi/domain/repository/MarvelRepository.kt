package feature.marvelapi.domain.repository

import feature.marvelapi.data.localdatasource.entity.CharacterEntity
import feature.marvelapi.presentation.model.MainPresentation

internal interface MarvelRepository {

    suspend fun getCharacters(offset: Int, name: String?): MainPresentation

    suspend fun getCharacterDetails(id: Int): MainPresentation

    suspend fun saveCharacterOnDB(character: CharacterEntity)

    suspend fun getAll() : List<CharacterEntity>
}
