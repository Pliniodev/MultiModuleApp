package feature.jsonplaceholder.domain

import java.io.Serializable

internal data class Post(
    val body: String?,
    val id: Int?,
    val title: String?,
    val userId: Int?
) : Serializable
