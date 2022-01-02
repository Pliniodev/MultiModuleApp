package feature.marvelapi.data.model

import com.google.gson.annotations.SerializedName

internal data class MainCharactersResponse(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    @SerializedName("etag")
    val eTag: String,
    val data: SubCharacterResponse
)

internal data class SubCharacterResponse(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharactersResponse>
)

internal data class CharactersResponse(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: ImagesResponse
)

internal data class ImagesResponse(
    val path: String,
    val extension: String
)
