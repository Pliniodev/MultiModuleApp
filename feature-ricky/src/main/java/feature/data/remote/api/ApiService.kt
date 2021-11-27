package feature.data.remote.api

import feature.data.remote.model.CharactersResponse
import feature.data.remote.model.EpisodeResponse
import feature.utils.constants.URL
import retrofit2.http.GET

interface ApiService {

    @GET(URL.EPISODE)
    suspend fun getEpisodes(): EpisodeResponse

    @GET(URL.CHARACTER_INFO)
    suspend fun getCharacters(): CharactersResponse
}
