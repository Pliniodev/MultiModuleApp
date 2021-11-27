package feature.dogs.data.remote.remotedatasource

import feature.dogs.domain.model.EpisodeInfoDomain

interface RemoteDataSourceRicky {
    suspend fun getEpisode(): EpisodeInfoDomain
}
