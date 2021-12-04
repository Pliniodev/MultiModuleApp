package feature.jsonplaceholder.data.mappers

import feature.jsonplaceholder.data.response.PostResponse
import feature.jsonplaceholder.domain.Post

internal object PostMapper {

    fun toDomain(response: List<PostResponse>): List<Post> {
        return response.map { postResponse ->
            with(postResponse) {
                Post(
                    body = body,
                    id = id,
                    title = title,
                    userId = userId
                )
            }
        }
    }
}
