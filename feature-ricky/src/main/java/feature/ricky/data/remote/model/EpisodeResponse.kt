package feature.ricky.data.remote.model

internal data class EpisodeResponse(
    val info: InfoResponse? = null,
    val results: List<ResultResponse>? = null
)

internal data class InfoResponse(
    val count: Int? = null,
    val next: String? = null,
    val pages: Int? = null,
    val prev: String? = null
)

internal data class ResultResponse(
    val airDate: String? = null,
    val characters: List<String>? = null,
    val created: String? = null,
    val episode: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val url: String? = null
)
