package feature.data.api

import feature.data.response.BreedsResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface DogsApiService {

    @GET("/breeds")
    suspend fun getBreeds(
        @Query(
            value = "page",
            encoded = true
        ) page: Int
    ) : BreedsResponse
}