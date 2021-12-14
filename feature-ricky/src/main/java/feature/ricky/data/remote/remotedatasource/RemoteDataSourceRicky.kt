package feature.ricky.data.remote.remotedatasource

import feature.ricky.domain.model.EpisodeDomain

internal interface RemoteDataSourceRicky {
    suspend fun getEpisode(): EpisodeDomain
}
