package feature.newsapi.data.response

internal data class EverythingResponse(
    val articles: List<ArticleResponse>? = null,
    val status: String? = null,
    val totalResults: Int? = null
)

internal data class ArticleResponse(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val source: SourceResponse? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null
)

internal data class SourceResponse(
    val id: String? = null,
    val name: String? = null
)
