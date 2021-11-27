package feature.data.remote.remotedatasource

import feature.domain.model.CharactersDomain
import feature.domain.model.CharactersInfoDomain
import feature.domain.model.EpisodeInfoDomain

interface RemoteDataSource {
    suspend fun getEpisode(): EpisodeInfoDomain
    suspend fun getCharacters(): CharactersInfoDomain
}
