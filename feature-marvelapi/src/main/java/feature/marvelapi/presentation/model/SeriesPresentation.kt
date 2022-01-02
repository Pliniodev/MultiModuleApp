package feature.marvelapi.presentation.model

import feature.marvelapi.domain.model.ImagesDomain

internal data class MainSeriesPresentation(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val eTag: String,
    val data: SubSeriesPresentation
)

internal data class SubSeriesPresentation(

    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<SeriesPresentation>
)

internal data class SeriesPresentation(
    val id: Int,
    val title: String,
    val description : String,
    val rating : String,
    val thumbnail : ImagesPresentation
)