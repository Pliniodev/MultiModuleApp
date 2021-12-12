package feature.ricky.data.remote.repository

import feature.ricky.data.remote.remotedatasource.RemoteDataSourceRicky
import feature.ricky.domain.mapper.EpisodeDomainMapper.toPresentation
import feature.ricky.domain.repository.ApiRepository
import feature.ricky.presentation.model.EpisodePresentation

internal class ApiRepositoryImpl(
    private val remoteDataSource: RemoteDataSourceRicky
) : ApiRepository {

    override suspend fun getEpisode(): EpisodePresentation =
        remoteDataSource.getEpisode().toPresentation()
}
