package feature.examples.apirequest.data.mappers

import feature.examples.apirequest.data.response.PostResponse
import feature.examples.apirequest.domain.Post

internal object PostMapper {
    fun toDomain(response: List<PostResponse>): List<Post> =
        response.map { postResponse ->
            Post(
                body = postResponse.body,
                id = postResponse.id,
                title = postResponse.title,
                userId = postResponse.userId
            )
        }
}
