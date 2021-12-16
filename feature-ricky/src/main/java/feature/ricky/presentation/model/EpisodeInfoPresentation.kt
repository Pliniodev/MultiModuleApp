package feature.ricky.presentation.model

internal data class EpisodePresentation(
    val info: InfoPresentation? = null,
    val results: List<ResultPresentation>? = null
)

internal data class InfoPresentation(
    val count: Int?,
    val next: String?,
    val pages: Int?,
    val prev: String?
)

internal data class ResultPresentation(
    val airDate: String? = null,
    val characters: List<String>? = null,
    val created: String? = null,
    val episode: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val url: String? = null
)
