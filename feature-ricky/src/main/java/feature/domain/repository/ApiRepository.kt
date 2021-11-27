package feature.domain.repository

import feature.presentation.model.EpisodeInfoPresentation
import feature.presentation.model.CharactersInfoPresentation

interface ApiRepository {

    suspend fun getEpisodeInfo(): EpisodeInfoPresentation
    suspend fun getCharacterInfo(): CharactersInfoPresentation
}
