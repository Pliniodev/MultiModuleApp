package feature.jsonplaceholder.data

import feature.commons.utils.saferequest.safeRequest
import feature.jsonplaceholder.data.mappers.PostMapper
import feature.jsonplaceholder.domain.service.JsonPlaceHolderService

internal class JsonPlaceHolderInfrastructure(
    private val api: JsonPlaceHolderGateway
) : JsonPlaceHolderService {
    override suspend fun getPosts() = safeRequest {
        PostMapper.toDomain(api.getPostResponses())
    }
}

