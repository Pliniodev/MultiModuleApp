package feature.marvelapi.domain.mapper

import feature.marvelapi.domain.model.CharactersDomain
import feature.marvelapi.domain.model.ImagesDomain
import feature.marvelapi.domain.model.MainDomain
import feature.marvelapi.domain.model.SubResponseDomain
import feature.marvelapi.presentation.model.CharactersPresentation
import feature.marvelapi.presentation.model.ImagesPresentation
import feature.marvelapi.presentation.model.MainPresentation
import feature.marvelapi.presentation.model.SubResponsePresentation

internal object MapperCharactersDomain {

    fun toPresentation(source: MainDomain): MainPresentation =
        with(source) {
            MainPresentation(
                code = code,
                status = status,
                copyright = copyright,
                attributionText = attributionText,
                attributionHTML = attributionHTML,
                eTag = eTag,
                data = subDomainToPresentation(data)

            )
        }

    private fun subDomainToPresentation(source: SubResponseDomain): SubResponsePresentation {
        with(source) {
            return SubResponsePresentation(
                offset = offset,
                limit = limit,
                total = total,
                count = count,
                results = characterDomainToPresentation(results)
            )
        }
    }

    private fun characterDomainToPresentation(source: List<CharactersDomain>): List<CharactersPresentation> =
        source.map { character ->
            with(character) {
                CharactersPresentation(
                    id = id,
                    name = name,
                    description = description,
                    thumbnail = thumbnailDomainToPresentation(thumbnail)
                )
            }
        }

    private fun thumbnailDomainToPresentation(source: ImagesDomain): ImagesPresentation =
        ImagesPresentation(
            path = source.path,
            extension = source.extension
        )
}
