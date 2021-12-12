package feature.marvelapi.data.repository

import feature.marvelapi.data.remotedatasource.RemoteDataSource
import feature.marvelapi.domain.mapper.CharactersDomainToPresentation
import feature.marvelapi.domain.repository.MarvelRepository
import feature.marvelapi.presentation.model.MainPresentation

internal class MarvelRepositoryImpl(private val remoteDataSource: RemoteDataSource) :
    MarvelRepository {

    override suspend fun getCharacters(): MainPresentation {
        return CharactersDomainToPresentation.domainToPresentation(remoteDataSource.getCharactersDomain())
    }
}