package feature.dogs.data.remote.repository

import feature.dogs.data.remote.remotedatasource.RemoteDataSourceRicky
import feature.dogs.domain.mapper.EpisodeDomainMapper
import feature.dogs.domain.repository.ApiRepository
import feature.dogs.presentation.model.EpisodeInfoPresentation

class ApiRepositoryImpl(
    private val remoteDataSource: RemoteDataSourceRicky
) : ApiRepository {

    override suspend fun getEpisodeInfo(): EpisodeInfoPresentation {
        return EpisodeDomainMapper.toInfoPresentation(remoteDataSource.getEpisode())
    }
}
