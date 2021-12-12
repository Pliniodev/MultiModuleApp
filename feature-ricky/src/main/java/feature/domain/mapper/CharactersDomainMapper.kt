package feature.domain.mapper

import feature.domain.model.CharactersDomain
import feature.presentation.model.CharactersInfoPresentation

object CharactersDomainMapper {

    fun toCharactersInfoPresentation(source: CharactersDomain): CharactersInfoPresentation =
        CharactersInfoPresentation(
            pages = source.pages,
            prev = source.prev,
            next = source.next,
            count = source.count
        )
}
