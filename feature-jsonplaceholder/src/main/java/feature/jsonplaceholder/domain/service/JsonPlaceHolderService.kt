package feature.jsonplaceholder.domain.service

import feature.commons.utils.StateMachine
import feature.jsonplaceholder.domain.Post

internal interface JsonPlaceHolderService {
    suspend fun getPosts(): StateMachine<List<Post>>
}
