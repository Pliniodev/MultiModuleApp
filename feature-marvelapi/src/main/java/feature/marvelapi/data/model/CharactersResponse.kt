package feature.marvelapi.data.model

import com.google.gson.annotations.SerializedName


data class MainResponse(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    @SerializedName("etag")
    val eTag: String,
    val data: SubResponse

)

data class SubResponse(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharactersResponse>
)

data class CharactersResponse(
    @SerializedName("name")
    val name: String?,
)