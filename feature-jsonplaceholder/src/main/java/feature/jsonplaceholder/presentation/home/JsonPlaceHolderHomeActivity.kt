package feature.jsonplaceholder.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import feature.jsonplaceholder.databinding.ActivityJsonPlaceHolderHomeBinding
import feature.jsonplaceholder.domain.Post
import feature.jsonplaceholder.jsonPlaceHolderModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class JsonPlaceHolderHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJsonPlaceHolderHomeBinding
    private val viewModel: JsonPlaceHolderHomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJsonPlaceHolderHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKoinModules(listOf(jsonPlaceHolderModule))
        onEnterActivity()
    }

    private fun onEnterActivity() {
        viewModel.getPosts()
        observers()
    }

    private fun observers() {
        viewModel.posts.observe(
            this,
            { posts ->
                posts?.let {
                    populateViews(posts)
                }
            }
        )
    }

    private fun populateViews(posts: List<Post>) {
        binding.title.text = posts[1].body.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(listOf(jsonPlaceHolderModule))
    }
}
