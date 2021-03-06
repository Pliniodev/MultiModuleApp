package feature.ricky.data.remote.api

import feature.ricky.data.remote.model.EpisodeResponse
import retrofit2.http.GET

internal interface ApiService {

    @GET("/api/episode")
    suspend fun getEpisodes(): EpisodeResponse
}
