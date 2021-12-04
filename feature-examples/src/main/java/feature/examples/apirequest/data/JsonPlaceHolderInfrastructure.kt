package feature.examples.apirequest.data

import feature.examples.apirequest.data.mappers.PostMapper
import feature.examples.apirequest.domain.Post
import feature.examples.apirequest.domain.service.JsonPlaceHolderService

internal class JsonPlaceHolderInfrastructure(
    private val api: JsonPlaceHolderGateway
) : JsonPlaceHolderService {
    override suspend fun getPosts(): List<Post> = PostMapper.toDomain(api.getPosts())
}
