package feature.newsapi.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_newsapi.databinding.ActivityNewsApiHomeBinding
import feature.commons.utils.navigateAndAggregate
import feature.newsapi.domain.model.Article
import feature.newsapi.newsApiModule
import feature.newsapi.presentation.NewsApiIntents.ARTICLE
import feature.newsapi.presentation.adapter.ArticlesAdapter
import feature.newsapi.presentation.articledetails.ArticleDetailsActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class NewsApiHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsApiHomeBinding
    private val viewModel: NewsApiHomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsApiHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKoinModules(newsApiModule)
        onEnterActivity()
    }

    private fun onEnterActivity() {
        getArticles()
    }

    private fun getArticles() {
        showLoading(true)
        viewModel.getEverything()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onNext = { populateViews(it.articles) },
                onComplete = { showLoading(false) },
                onError = { throwable ->
                    Log.e("", "Error: ${throwable.message}")
                }
            )
    }

    private fun populateViews(articleList: List<Article>?) {
        val adapter = articleList?.let { articles ->
            ArticlesAdapter(
                articles = articles,
                action = { article -> aggregateAndGoToDetails(article) }
            )
        }
        binding.articlesRv.adapter = adapter
    }

    private fun aggregateAndGoToDetails(article: Article) {
        navigateAndAggregate<ArticleDetailsActivity, Article>(
            intentName = ARTICLE,
            send = article
        )
    }

    private fun showLoading(isLoading: Boolean) {
        binding.viewFlipper.displayedChild = if (isLoading) LOADING else ARTICLE_RV
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(newsApiModule)
    }

    companion object {
        const val LOADING = 1
        const val ARTICLE_RV = 0
    }
}
