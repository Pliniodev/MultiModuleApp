package feature.data.remote.remotedatasource

import feature.data.remote.api.ApiService
import feature.data.remote.mapper.CharactersMapper
import feature.data.remote.mapper.EpisodeMapper
import feature.domain.model.CharactersInfoDomain
import feature.domain.model.EpisodeInfoDomain


class RemoteDatasourceImpl(
    private val api: ApiService
) : RemoteDataSource {

    override suspend fun getEpisode(): EpisodeInfoDomain {
        return EpisodeMapper.toEpisodeInfoDomain(api.getEpisodes())
    }

    override suspend fun getCharacters(): CharactersInfoDomain {
        return CharactersMapper.toCharactersInfoDomain(api.getCharacters())
    }
}
