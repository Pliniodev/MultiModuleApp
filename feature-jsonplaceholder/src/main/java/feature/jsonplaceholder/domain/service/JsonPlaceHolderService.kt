package feature.jsonplaceholder.domain.service

import feature.jsonplaceholder.domain.Post

internal interface JsonPlaceHolderService {
    suspend fun getPosts(): List<Post>
}