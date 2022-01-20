package feature.marvelapi.data.api

import feature.marvelapi.data.model.MainCharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MarvelApi {

    @GET("characters")
    suspend fun getCharacters(
        @Query("offset") offset: Int,
        @Query("nameStartsWith") name: String? = null,
        @Query("limit") limit: Int = 40
    ): MainCharactersResponse
}
