package feature.data.remote.repository

import feature.data.remote.remotedatasource.RemoteDataSource
import feature.domain.mapper.CharactersDomainMapper
import feature.domain.mapper.EpisodeDomainMapper
import feature.domain.repository.ApiRepository
import feature.presentation.model.CharactersInfoPresentation
import feature.presentation.model.EpisodeInfoPresentation

class ApiRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : ApiRepository {

    override suspend fun getEpisodeInfo(): EpisodeInfoPresentation {
        return EpisodeDomainMapper.toInfoPresentation(remoteDataSource.getEpisode())
    }

    override suspend fun getCharacterInfo(): CharactersInfoPresentation {
        return CharactersDomainMapper.toCharactersInfoPresentation(remoteDataSource.getCharacters())
    }

}
