package feature.marvelapi.data.api

import feature.marvelapi.data.model.Someeeee
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("Characters")
    suspend fun test(
        @Query("api-key") apiKey: String = Util.publicKey,
        @Query("ts") ts: String = Util.ts,
        @Query("hash") hash : String = Util.hash
    ): Someeeee
//
//    @GET("Characters")
//    suspend fun test(): Someeeee
}