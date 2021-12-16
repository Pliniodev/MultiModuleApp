package feature.ricky.domain.mapper

import feature.ricky.domain.model.EpisodeDomain
import feature.ricky.domain.model.InfoDomain
import feature.ricky.domain.model.ResultDomain
import feature.ricky.presentation.model.EpisodePresentation
import feature.ricky.presentation.model.InfoPresentation
import feature.ricky.presentation.model.ResultPresentation

internal object EpisodeDomainMapper {

    fun EpisodeDomain.toPresentation() =
        EpisodePresentation(
            info = info?.toInfoPresentation(),
            results = toResultDomain(results)
        )

    private fun toResultDomain(results: List<ResultDomain>?): List<ResultPresentation>? =
        results?.map { result ->
            with(result) {
                ResultPresentation(
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

    private fun InfoDomain.toInfoPresentation(): InfoPresentation =
        InfoPresentation(
            count = count,
            next = next,
            pages = pages,
            prev = prev
        )
}
