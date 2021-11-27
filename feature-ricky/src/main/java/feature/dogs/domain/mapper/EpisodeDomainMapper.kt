package feature.dogs.domain.mapper

import feature.dogs.domain.model.EpisodeInfoDomain
import feature.dogs.presentation.model.EpisodeInfoPresentation

internal object EpisodeDomainMapper {

    fun toInfoPresentation(source: EpisodeInfoDomain): EpisodeInfoPresentation =
        EpisodeInfoPresentation(
            pages = source.pages,
            prev = source.prev,
            next = source.next,
            count = source.count
        )
}
