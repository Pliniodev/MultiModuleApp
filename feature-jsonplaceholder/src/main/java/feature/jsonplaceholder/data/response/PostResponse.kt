package feature.jsonplaceholder.data.response

import com.google.gson.annotations.SerializedName

internal data class PostResponse(
    val body: String? = null,
    val id: Int? = null,
    val title: String? = null,
    @SerializedName("userId") val userId: Int? = null
)
