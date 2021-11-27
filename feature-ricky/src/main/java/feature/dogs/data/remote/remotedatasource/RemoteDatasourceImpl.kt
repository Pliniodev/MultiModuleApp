package feature.dogs.data.remote.remotedatasource

import feature.dogs.data.remote.api.ApiService
import feature.dogs.data.remote.mapper.EpisodeMapper
import feature.dogs.domain.model.EpisodeInfoDomain

class RemoteDatasourceImpl(
    private val api: ApiService
) : RemoteDataSourceRicky {

    override suspend fun getEpisode(): EpisodeInfoDomain {
        return EpisodeMapper.toEpisodeInfoDomain(api.getEpisodes())
    }
}
