package feature.jsonplaceholder.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import feature.commons.utils.StateMachine
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
        retrievePosts()
    }

    private fun retrievePosts() {
        viewModel.getPosts().observe(this) { event ->
            when (event) {
                is StateMachine.Loading -> showLoading(true)
                is StateMachine.Success -> populateViews(event.value)
                is StateMachine.Failure -> handleError(event.error.message)
                is StateMachine.Finish -> showLoading(false)
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.viewFlipper.displayedChild = if (isLoading) 1 else 0
    }

    private fun populateViews(posts: List<Post>) {
        binding.title.text = posts[1].body.toString()
    }

    private fun handleError(errorMsg: String?) {
        binding.title.text = errorMsg
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(listOf(jsonPlaceHolderModule))
    }
}
