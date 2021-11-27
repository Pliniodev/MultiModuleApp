package feature.data.remote.model

import com.google.gson.annotations.SerializedName

data class EpisodeResponse(
    @SerializedName("info")
    val info: Info? = null,
    @SerializedName("results")
    val results: List<Result>? = null,
) {
    data class Info(
        @SerializedName("count")
        val count: Int? = null,
        @SerializedName("next")
        val next: String? = null,
        @SerializedName("pages")
        val pages: Int? = null,
        @SerializedName("prev")
        val prev: String? = null
    )

    data class Result(
        @SerializedName("air_date")
        val airDate: String? = null,
        @SerializedName("characters")
        val characters: List<String>?,
        @SerializedName("created")
        val created: String? = null,
        @SerializedName("episode")
        val episode: String? = null,
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("url")
        val url: String? = null
    )
}
