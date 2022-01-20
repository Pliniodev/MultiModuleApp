package feature.marvelapi.domain.repository

import feature.marvelapi.data.remotedatasource.RemoteDataSource
import feature.marvelapi.domain.mapper.MapperCharactersDomain
import feature.marvelapi.presentation.model.MainPresentation
import feature.marvelapi.presentation.model.MainSeriesPresentation

internal class MarvelRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : MarvelRepository {

    override suspend fun getCharacters(offset: Int, name: String?): MainPresentation {
        return MapperCharactersDomain.toPresentation(remoteDataSource.getCharactersDomain(offset, name))
    }
}
