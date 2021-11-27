package feature.dogs.data.remote.mapper

import feature.dogs.data.remote.model.EpisodeResponse
import feature.dogs.domain.model.EpisodeInfoDomain

object EpisodeMapper {

    fun toEpisodeInfoDomain(source: EpisodeResponse): EpisodeInfoDomain =
        EpisodeInfoDomain(
            count = source.info?.count,
            next = source.info?.next,
            pages = source.info?.pages,
            prev = source.info?.prev
        )
}
