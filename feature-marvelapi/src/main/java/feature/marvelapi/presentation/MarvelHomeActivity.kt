package feature.marvelapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import feature.marvelapi.R
import feature.marvelapi.databinding.ActivityMarvelHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MarvelHomeActivity : AppCompatActivity() {

    private val viewModel: MarvelHomeViewModel by viewModel()

    private lateinit var binding: ActivityMarvelHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarvelHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.test.observe(this, {
            binding.mainText.text = it.name
        })
    }
}