package feature.ricky.domain.model

internal data class EpisodeDomain(
    val info: InfoDomain? = null,
    val results: List<ResultDomain>? = null
)

internal data class InfoDomain(
    val count: Int? = null,
    val next: String? = null,
    val pages: Int? = null,
    val prev: String? = null
)

internal data class ResultDomain(
    val airDate: String? = null,
    val characters: List<String>? = null,
    val created: String? = null,
    val episode: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val url: String? = null
)
