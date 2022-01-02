package feature.marvelapi.domain.model

internal data class MainSeriesDomain(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val eTag: String,
    val data: SubSeriesDomain
)

internal data class SubSeriesDomain(

    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<SeriesDomain>
)

internal data class SeriesDomain(
    val id: Int,
    val title: String,
    val description : String,
    val rating : String,
    val thumbnail : ImagesDomain
)