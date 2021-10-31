package feature.domain.mapper

import feature.domain.model.EpisodeInfoDomain
import feature.presentation.model.EpisodeInfoPresentation

internal object EpisodeDomainMapper {

    fun toInfoPresentation(source: EpisodeInfoDomain): EpisodeInfoPresentation =
            EpisodeInfoPresentation(
                pages = source.pages,
                prev = source.prev,
                next = source.next,
                count = source.count
            )
        }
