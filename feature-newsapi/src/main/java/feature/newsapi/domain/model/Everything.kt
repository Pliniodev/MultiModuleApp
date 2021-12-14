package feature.newsapi.domain.model

import java.io.Serializable

internal data class Everything(
    val articles: List<Article>? = null,
    val status: String? = null,
    val totalResults: Int? = null
) : Serializable

internal data class Article(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val source: Source? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null
) : Serializable

internal data class Source(
    val id: String? = null,
    val name: String? = null
) : Serializable
