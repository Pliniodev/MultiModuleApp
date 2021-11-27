package feature.dogs.domain.repository

import feature.dogs.presentation.model.EpisodeInfoPresentation

interface ApiRepository {
    suspend fun getEpisodeInfo(): EpisodeInfoPresentation
}
