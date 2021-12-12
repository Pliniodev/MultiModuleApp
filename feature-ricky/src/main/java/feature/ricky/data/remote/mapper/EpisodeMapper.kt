package feature.ricky.data.remote.mapper

import feature.ricky.data.remote.model.EpisodeResponse
import feature.ricky.data.remote.model.InfoResponse
import feature.ricky.data.remote.model.ResultResponse
import feature.ricky.domain.model.EpisodeDomain
import feature.ricky.domain.model.InfoDomain
import feature.ricky.domain.model.ResultDomain

internal object EpisodeMapper {

    fun EpisodeResponse.toDomain() =
        EpisodeDomain(
            info = info?.toInfoDomain(),
            results = toResultDomain(results)
        )

    private fun toResultDomain(results: List<ResultResponse>?): List<ResultDomain>? =
        results?.map { result ->
            with(result) {
                ResultDomain(
                    airDate = airDate,
                    characters = characters,
                    created = created,
                    episode = episode,
                    id = id,
                    name = name,
                    url = url,
                )
            }
        }

    private fun InfoResponse.toInfoDomain(): InfoDomain =
        InfoDomain(
            count = count,
            next = next,
            pages = pages,
            prev = prev
        )
}
