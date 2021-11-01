package feature.data.remote.remotedatasource

import feature.domain.model.EpisodeInfoDomain

interface RemoteDataSource {
    suspend fun getEpisode(): EpisodeInfoDomain
}
