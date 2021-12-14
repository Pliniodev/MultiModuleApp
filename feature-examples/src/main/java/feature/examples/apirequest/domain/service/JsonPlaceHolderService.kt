package feature.examples.apirequest.domain.service

import feature.examples.apirequest.domain.model.Post

internal interface JsonPlaceHolderService {
    suspend fun getPosts(): List<Post>
}
