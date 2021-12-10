package feature.newsapi.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_newsapi.databinding.ActivityNewsApiHomeBinding
import feature.newsapi.newsApiModule
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
        observers()
        viewModel.makeApiCall()
    }

    private fun observers() {
        viewModel.isLoading.observe(this, { showLoading(it) })
        viewModel.articles.observe(
            this,
            {
                binding.viewFlipper.displayedChild = 1
                binding.title.text = it.toString()
            }
        )
    }

    private fun showLoading(isLoading: Boolean) {
        binding.viewFlipper.displayedChild = if (isLoading) LOADING else ARTICLES
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(newsApiModule)
    }

    companion object{
        const val LOADING = 1
        const val ARTICLES = 0
    }
}
