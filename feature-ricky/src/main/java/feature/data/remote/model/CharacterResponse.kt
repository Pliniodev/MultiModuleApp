package feature.data.remote.model

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info")
    val info: InfoResponse? = null,
    @SerializedName("results")
    val results: List<Result>? = null
) {

    data class InfoResponse(
        @SerializedName("count")
        val count: Int? = null,
        @SerializedName("next")
        val next: String? = null,
        @SerializedName("pages")
        val pages: Int? = null,
        @SerializedName("prev")
        val prev: Int? = null
    )

    data class Result(
        @SerializedName("created")
        val created: String? = null,
        @SerializedName("episode")
        val episode: List<String>? = null,
        @SerializedName("gender")
        val gender: String? = null,
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("image")
        val image: String? = null,
        @SerializedName("location")
        val location: Location? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("origin")
        val origin: Origin? = null,
        @SerializedName("species")
        val species: String? = null,
        @SerializedName("status")
        val status: String? = null,
        @SerializedName("type")
        val type: String? = null,
        @SerializedName("url")
        val url: String? = null
    )

    data class Location(
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("url")
        val url: String? = null
    )

    data class Origin(
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("url")
        val url: String? = null
    )
}
