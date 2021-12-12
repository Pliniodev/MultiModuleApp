package feature.ricky.domain.model

internal data class EpisodeInfoDomain(
    val count: Int?,
    val next: String?,
    val pages: Int?,
    val prev: String?
)

internal data class EpisodeResultDomain(
    val airDate: String?,
    val characters: List<String>?,
    val created: String?,
    val episode: String?,
    val id: Int?,
    val name: String?,
    val url: String?
)
