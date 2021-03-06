package feature.marvelapi.data.mapper

import feature.marvelapi.data.model.CharactersResponse
import feature.marvelapi.data.model.ImagesResponse
import feature.marvelapi.data.model.MainResponse
import feature.marvelapi.data.model.SubResponse
import feature.marvelapi.domain.model.CharactersDomain
import feature.marvelapi.domain.model.ImagesDomain
import feature.marvelapi.domain.model.MainDomain
import feature.marvelapi.domain.model.SubResponseDomain

internal object MapperCharactersResponse {

    fun toDomain(source: MainResponse): MainDomain =
        with(source) {
            MainDomain(
                code = code,
                status = status,
                copyright = copyright,
                attributionText = attributionText,
                attributionHTML = attributionHTML,
                eTag = eTag,
                data = subResponseToDomain(data)
            )
        }

    private fun subResponseToDomain(source: SubResponse): SubResponseDomain {
        with(source) {
            return SubResponseDomain(
                offset = offset,
                limit = limit,
                total = total,
                count = count,
                results = charactersToDomain(results)
            )
        }
    }

    private fun charactersToDomain(source: List<CharactersResponse>): List<CharactersDomain> =
        source.map { character ->
            with(character) {
                CharactersDomain(
                    id = id,
                    name = name,
                    description = description,
                    thumbnail = thumbnailResponseToDomain(thumbnail)
                )
            }
        }

    private fun thumbnailResponseToDomain(source: ImagesResponse): ImagesDomain =
        ImagesDomain(
            path = source.path,
            extension = source.extension
        )
}
