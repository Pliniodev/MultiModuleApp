package feature.marvelapi.data.model

import com.google.gson.annotations.SerializedName

internal data class MainSeriesResponse(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    @SerializedName("etag")
    val eTag: String,
    val data: SubSeriesResponse
)

internal data class SubSeriesResponse(

    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<SeriesResponse>
)

internal data class SeriesResponse(
    val id: Int,
    val title: String,
    val description : String,
    val rating : String,
    val thumbnail : ImagesResponse
)