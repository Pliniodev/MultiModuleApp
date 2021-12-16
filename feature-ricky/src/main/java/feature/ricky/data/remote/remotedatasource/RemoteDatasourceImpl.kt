package feature.ricky.data.remote.remotedatasource

import feature.ricky.data.remote.api.ApiService
import feature.ricky.data.remote.mapper.EpisodeMapper.toDomain
import feature.ricky.domain.model.EpisodeDomain

internal class RemoteDatasourceImpl(
    private val api: ApiService
) : RemoteDataSourceRicky {
    override suspend fun getEpisode(): EpisodeDomain = api.getEpisodes().toDomain()
}
