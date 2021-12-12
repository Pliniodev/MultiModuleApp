package feature.ricky.data.remote.remotedatasource

import feature.ricky.domain.model.EpisodeInfoDomain

internal interface RemoteDataSourceRicky {
    suspend fun getEpisode(): EpisodeInfoDomain
}
