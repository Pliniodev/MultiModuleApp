package feature.jsonplaceholder.data

import feature.jsonplaceholder.data.response.PostResponse
import retrofit2.http.GET

internal interface JsonPlaceHolderGateway {
    @GET("/posts")
    suspend fun getPosts(): List<PostResponse>
}