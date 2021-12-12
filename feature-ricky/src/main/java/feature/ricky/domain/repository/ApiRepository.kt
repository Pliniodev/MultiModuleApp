package feature.ricky.domain.repository

import feature.ricky.presentation.model.EpisodePresentation

internal interface ApiRepository {
    suspend fun getEpisode(): EpisodePresentation
}
