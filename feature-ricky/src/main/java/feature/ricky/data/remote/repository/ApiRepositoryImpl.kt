package feature.ricky.data.remote.repository

import feature.ricky.data.remote.remotedatasource.RemoteDataSourceRicky
import feature.ricky.domain.mapper.EpisodeDomainMapper
import feature.ricky.domain.repository.ApiRepository
import feature.ricky.presentation.model.EpisodeInfoPresentation

class ApiRepositoryImpl(
    private val remoteDataSource: RemoteDataSourceRicky
) : ApiRepository {

    override suspend fun getEpisodeInfo(): EpisodeInfoPresentation {
        return EpisodeDomainMapper.toInfoPresentation(remoteDataSource.getEpisode())
    }
}
