package feature.marvelapi.data.mapper

import feature.marvelapi.data.model.CharactersResponse
import feature.marvelapi.data.model.ImagesResponse
import feature.marvelapi.data.model.MainCharactersResponse
import feature.marvelapi.data.model.SubCharacterResponse
import feature.marvelapi.domain.model.CharactersDomain
import feature.marvelapi.domain.model.ImagesDomain
import feature.marvelapi.domain.model.MainCharactersDomain
import feature.marvelapi.domain.model.SubCharactersDomain

internal object MapperCharactersResponse {

    fun toDomain(source: MainCharactersResponse): MainCharactersDomain =
        with(source) {
            MainCharactersDomain(
                code = code,
                status = status,
                copyright = copyright,
                attributionText = attributionText,
                attributionHTML = attributionHTML,
                eTag = eTag,
                data = subResponseToDomain(data)
            )
        }

    private fun subResponseToDomain(source: SubCharacterResponse): SubCharactersDomain {
        with(source) {
            return SubCharactersDomain(
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
