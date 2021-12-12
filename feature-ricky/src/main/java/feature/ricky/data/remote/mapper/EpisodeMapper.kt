package feature.ricky.data.remote.mapper

import feature.ricky.data.remote.model.EpisodeResponse
import feature.ricky.domain.model.EpisodeInfoDomain

internal object EpisodeMapper {

    fun toEpisodeInfoDomain(source: EpisodeResponse): EpisodeInfoDomain =
        EpisodeInfoDomain(
            count = source.info?.count,
            next = source.info?.next,
            pages = source.info?.pages,
            prev = source.info?.prev
        )
}
