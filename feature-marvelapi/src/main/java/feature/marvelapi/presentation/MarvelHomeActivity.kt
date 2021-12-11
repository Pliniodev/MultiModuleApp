package feature.marvelapi.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import feature.marvelapi.R
import feature.marvelapi.databinding.ActivityMarvelHomeBinding
import feature.marvelapi.marvelModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class MarvelHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarvelHomeBinding

    private val viewModel: MarvelHomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarvelHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKoinModules(marvelModule)

        viewModel.test.observe(this, {
            binding.mainText.text = it.name
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(listOf(marvelModule))
    }
}