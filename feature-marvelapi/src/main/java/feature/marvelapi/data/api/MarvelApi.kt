package feature.marvelapi.data.api

import feature.marvelapi.data.model.MainResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MarvelApi {

    @GET("characters")
    suspend fun getCharacters(): MainResponse
}
