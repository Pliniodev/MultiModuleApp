package feature.dogs.data.remote.api

import feature.dogs.data.remote.model.EpisodeResponse
import retrofit2.http.GET

interface ApiService {

    @GET("/api/episode")
    suspend fun getEpisodes(): EpisodeResponse
}
