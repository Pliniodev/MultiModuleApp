package feature.data.remote.api

import feature.data.remote.model.EpisodeResponse
import feature.utils.constants.URL
import retrofit2.http.GET

interface ApiService {

    @GET(URL.EPISODE)
    suspend fun getEpisodes(): EpisodeResponse
}