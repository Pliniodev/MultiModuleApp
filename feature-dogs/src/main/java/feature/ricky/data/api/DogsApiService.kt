package feature.ricky.data.api

import feature.ricky.data.response.BreedResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface DogsApiService {

    @GET("breeds")
    suspend fun getBreedsByPage(
        @Query(
            value = "page",
            encoded = true
        ) page: Int,
        @Query(
            value = "limit",
            encoded = true
        ) limitOfBreeds: Int
    ): List<BreedResponse>
}
