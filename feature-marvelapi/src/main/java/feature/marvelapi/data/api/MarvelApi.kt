package feature.marvelapi.data.api

import feature.marvelapi.data.model.MainResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("characters")
    suspend fun test(
        @Query("apikey") apiKey: String = Util.publicKey,
        @Query("ts") ts: String = Util.ts,
        @Query("hash") hash : String = Util.hash
    ): MainResponse
}