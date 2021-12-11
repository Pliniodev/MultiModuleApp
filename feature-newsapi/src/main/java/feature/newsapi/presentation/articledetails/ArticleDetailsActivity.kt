package feature.newsapi.presentation.articledetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.feature_newsapi.R
import com.example.feature_newsapi.databinding.ActivityArticleDetailsBinding
import feature.newsapi.domain.model.Article
import feature.newsapi.presentation.NewsApiIntents.ARTICLE

internal class ArticleDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleDetailsBinding
    private val article
        get() = intent.getSerializableExtra(ARTICLE) as? Article

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onEnterActivity()
    }

    private fun onEnterActivity() {
        renderScreen()
    }

    private fun renderScreen() {
        binding.apply {
            article?.let { article ->
                articleTitle.text = article.title
                Glide.with(this@ArticleDetailsActivity)
                    .load(article.urlToImage)
                    .placeholder(R.drawable.ic_baseline_portrait_24)
                    .into(articleImage)
                articleDescription.text = article.description
            }
        }
    }
}