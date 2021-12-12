package feature.ricky.domain.repository

import feature.ricky.presentation.model.EpisodeInfoPresentation

internal interface ApiRepository {
    suspend fun getEpisodeInfo(): EpisodeInfoPresentation
}
