package feature.examples.apirequest.data

import feature.examples.apirequest.data.response.PostResponse
import retrofit2.http.GET

internal interface JsonPlaceHolderGateway {
    @GET("/posts")
    suspend fun getPosts(): List<PostResponse>
}
