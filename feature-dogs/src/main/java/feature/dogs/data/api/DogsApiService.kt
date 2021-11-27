package feature.dogs.data.api

import feature.dogs.data.response.BreedResponse
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
