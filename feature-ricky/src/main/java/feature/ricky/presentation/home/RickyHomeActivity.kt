package feature.ricky.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import feature.feature_ricky.databinding.ActivityHomeRickyBinding
import feature.ricky.rickyAndMortyModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class RickyHomeActivity : AppCompatActivity() {
    private val viewModel: RickyHomeViewModel by viewModel()
    private lateinit var binding: ActivityHomeRickyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeRickyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKoinModules(rickyAndMortyModule)

        onEnterActivity()
        observer()
    }

    private fun observer() {
        viewModel.episode.observe(
            this,
            { episodePresentation ->
                binding.episodes.text = episodePresentation.results?.map {
                    it.characters
                }.toString()
            }
        )
    }

    private fun onEnterActivity() {
        viewModel.getEpisodes()
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(rickyAndMortyModule)
    }
}
