package feature.data.remote.mapper

import feature.data.remote.model.EpisodeResponse
import feature.domain.model.EpisodeInfoDomain

object EpisodeMapper {

    fun toEpisodeInfoDomain(source: EpisodeResponse): EpisodeInfoDomain =
        EpisodeInfoDomain(
            count = source.info?.count,
            next = source.info?.next,
            pages = source.info?.pages,
            prev = source.info?.prev
        )
}
