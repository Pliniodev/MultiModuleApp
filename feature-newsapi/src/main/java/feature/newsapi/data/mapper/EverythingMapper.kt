package feature.newsapi.data.mapper

import feature.newsapi.data.response.ArticleResponse
import feature.newsapi.data.response.EverythingResponse
import feature.newsapi.data.response.SourceResponse
import feature.newsapi.domain.model.Article
import feature.newsapi.domain.model.Everything
import feature.newsapi.domain.model.Source

internal object EverythingMapper {
    fun toDomain(response: EverythingResponse): Everything =
        Everything(
            articles = toArticlesDomain(response.articles),
            status = response.status,
            totalResults = response.totalResults
        )

    private fun toArticlesDomain(response: List<ArticleResponse>?): List<Article>? {
        return response?.map { articleResponse ->
            with(articleResponse) {
                Article(
                    author = author,
                    content = content,
                    description = description,
                    publishedAt = publishedAt,
                    source = source?.toSourceDomain(),
                    title = title,
                    url = url,
                    urlToImage = urlToImage
                )
            }
        }
    }

    private fun SourceResponse.toSourceDomain(): Source =
        Source(
            id = id,
            name = name
        )
}
