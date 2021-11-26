package feature.data.remote.remotedatasource

import feature.domain.model.EpisodeInfoDomain

interface RemoteDataSourceRicky {
    suspend fun getEpisode(): EpisodeInfoDomain
}
