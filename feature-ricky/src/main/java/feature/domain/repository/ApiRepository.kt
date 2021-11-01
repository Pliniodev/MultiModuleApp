package feature.domain.repository

import feature.presentation.model.EpisodeInfoPresentation

interface ApiRepository {
    suspend fun getEpisodeInfo(): EpisodeInfoPresentation
}
