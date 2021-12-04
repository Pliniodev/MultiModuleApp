package feature.examples.apirequest.domain.service

import feature.examples.apirequest.domain.Post

internal interface JsonPlaceHolderService {
    suspend fun getPosts(): List<Post>
}
