package feature.examples.apirequest.data.mappers

import feature.examples.apirequest.data.response.PostResponse
import feature.examples.apirequest.domain.model.Post

/**
 * The function of the mapper is, parse(transform, convert) the response object of the data layer
 * in the object of the domain layer.
 * In this case, the api return a list of objectResponse, so we parse the objectResponse to objectDomain
 * using the "map".
 * This extension function of the Iterable from the kotlin.collections return a element of the list that
 * we desire to parse.
 * So, using this element we parse the response object to object of the domain layer
 *
 * In other words:
 *
 * listOfResponseObjects.map { oneElementOfTheListOfResponseObject ->
 *     ObjectOfTheDomainLayer(
 *          attributeOfObjectOfTheDomainLayer = oneElementOfTheListOfResponseObject.attributeOfObjectOfTheResponseObject
 *     )
 * }
 */
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
