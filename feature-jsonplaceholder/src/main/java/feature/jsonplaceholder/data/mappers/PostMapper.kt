package feature.jsonplaceholder.data.mappers

import feature.jsonplaceholder.data.response.PostResponse
import feature.jsonplaceholder.domain.Post

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
