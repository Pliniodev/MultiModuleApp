package feature.ricky.domain.repository

import feature.ricky.presentation.model.EpisodeInfoPresentation

interface ApiRepository {
    suspend fun getEpisodeInfo(): EpisodeInfoPresentation
}
