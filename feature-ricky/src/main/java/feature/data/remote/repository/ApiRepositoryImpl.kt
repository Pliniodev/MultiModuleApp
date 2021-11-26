package feature.data.remote.repository

import feature.data.remote.remotedatasource.RemoteDataSourceRicky
import feature.domain.mapper.EpisodeDomainMapper
import feature.domain.repository.ApiRepository
import feature.presentation.model.EpisodeInfoPresentation

class ApiRepositoryImpl(
    private val remoteDataSource: RemoteDataSourceRicky
) : ApiRepository {

    override suspend fun getEpisodeInfo(): EpisodeInfoPresentation {
        return EpisodeDomainMapper.toInfoPresentation(remoteDataSource.getEpisode())
    }
}
