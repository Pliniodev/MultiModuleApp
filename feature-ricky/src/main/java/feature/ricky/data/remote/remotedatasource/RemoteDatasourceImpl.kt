package feature.ricky.data.remote.remotedatasource

import feature.ricky.data.remote.api.ApiService
import feature.ricky.data.remote.mapper.EpisodeMapper
import feature.ricky.domain.model.EpisodeInfoDomain

class RemoteDatasourceImpl(
    private val api: ApiService
) : RemoteDataSourceRicky {

    override suspend fun getEpisode(): EpisodeInfoDomain {
        return EpisodeMapper.toEpisodeInfoDomain(api.getEpisodes())
    }
}
