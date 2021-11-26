package feature.data.remote.remotedatasource

import feature.data.remote.api.ApiService
import feature.data.remote.mapper.EpisodeMapper
import feature.domain.model.EpisodeInfoDomain

class RemoteDatasourceImpl(
    private val api: ApiService
) : RemoteDataSourceRicky {

    override suspend fun getEpisode(): EpisodeInfoDomain {
        return EpisodeMapper.toEpisodeInfoDomain(api.getEpisodes())
    }
}
