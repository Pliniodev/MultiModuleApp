package feature.jsonplaceholder.data

import feature.jsonplaceholder.data.mappers.PostMapper
import feature.jsonplaceholder.domain.Post
import feature.jsonplaceholder.domain.service.JsonPlaceHolderService

internal class JsonPlaceHolderInfrastructure(
    private val api: JsonPlaceHolderGateway
) : JsonPlaceHolderService {
    override suspend fun getPosts(): List<Post> = PostMapper.toDomain(api.getPostResponses())
}
