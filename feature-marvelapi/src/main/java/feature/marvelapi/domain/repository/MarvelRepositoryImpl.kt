package feature.marvelapi.domain.repository

import feature.marvelapi.data.localdatasource.LocalDataSource
import feature.marvelapi.data.localdatasource.entity.CharacterEntity
import feature.marvelapi.data.remotedatasource.RemoteDataSource
import feature.marvelapi.domain.mapper.MapperCharactersDomain
import feature.marvelapi.presentation.model.MainPresentation

internal class MarvelRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource : LocalDataSource
) : MarvelRepository {

    override suspend fun getCharacters(offset: Int, name: String?): MainPresentation {
        return MapperCharactersDomain.toPresentation(remoteDataSource.getCharactersDomain(offset, name))
    }

    override suspend fun getCharacterDetails(id: Int): MainPresentation {
        return MapperCharactersDomain.toPresentation(remoteDataSource.getCharacterDetailsDomain(id))
    }

    override suspend fun saveCharacterOnDB(character: CharacterEntity) {
        localDataSource.saveCharacterOnDB(character)
    }

    override suspend fun getAll(): List<CharacterEntity> {
        return localDataSource.getAll()
    }

    override suspend fun characterConsult(id: Long): CharacterEntity? {
        return localDataSource.consultCharacter(id)
    }
}
