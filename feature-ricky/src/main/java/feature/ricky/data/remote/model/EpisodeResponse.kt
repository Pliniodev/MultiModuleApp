package feature.ricky.data.remote.model

internal data class EpisodeResponse(
    val info: InfoResponse?,
    val results: List<ResultResponse>?
)

internal data class InfoResponse(
    val count: Int?,
    val next: String?,
    val pages: Int?,
    val prev: String?
)

internal data class ResultResponse(
    val airDate: String?,
    val characters: List<String>?,
    val created: String?,
    val episode: String?,
    val id: Int?,
    val name: String?,
    val url: String?
)
