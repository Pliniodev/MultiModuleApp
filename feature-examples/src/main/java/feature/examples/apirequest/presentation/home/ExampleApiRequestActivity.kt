package feature.examples.apirequest.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_examples.databinding.ActivityExampleApiRequestBinding
import feature.examples.apirequest.domain.model.Post
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class ExampleApiRequestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExampleApiRequestBinding
    private val viewModel: ExampleApiRequestHomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExampleApiRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onEnterActivity()
    }

    private fun onEnterActivity() {
        viewModel.getPosts()
        observers()
    }

    private fun observers() {
        viewModel.posts.observe(this, { posts -> populateViews(posts) })
    }

    private fun populateViews(posts: List<Post>) {
        binding.title.text = posts[1].body.toString()
    }
}
