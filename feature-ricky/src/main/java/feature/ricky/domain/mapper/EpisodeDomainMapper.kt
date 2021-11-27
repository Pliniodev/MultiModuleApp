package feature.ricky.domain.mapper

import feature.ricky.domain.model.EpisodeInfoDomain
import feature.ricky.presentation.model.EpisodeInfoPresentation

internal object EpisodeDomainMapper {

    fun toInfoPresentation(source: EpisodeInfoDomain): EpisodeInfoPresentation =
        EpisodeInfoPresentation(
            pages = source.pages,
            prev = source.prev,
            next = source.next,
            count = source.count
        )
}
