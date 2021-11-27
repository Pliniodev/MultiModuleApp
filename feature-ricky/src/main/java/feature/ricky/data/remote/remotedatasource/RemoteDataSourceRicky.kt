package feature.ricky.data.remote.remotedatasource

import feature.ricky.domain.model.EpisodeInfoDomain

interface RemoteDataSourceRicky {
    suspend fun getEpisode(): EpisodeInfoDomain
}
