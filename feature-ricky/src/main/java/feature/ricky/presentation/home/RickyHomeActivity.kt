package feature.ricky.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import feature.dataModule
import feature.dataRickyAndMortyModule
import feature.databaseModule
import feature.feature_ricky.databinding.ActivityHomeRickyBinding
import feature.networkRickyAndMortyModule
import feature.ricky.presentation.episodes.EpisodesActivity
import feature.rickyAndMortyModule
import feature.commons.utils.navigateTo
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
        loadModules()

        onEnterActivity()
        viewModel.getEpisodes()
    }

    private fun onEnterActivity() {
        setupViews()
    }

    private fun setupViews() {
        binding.buttonEpisodes.setOnClickListener {
            navigateTo<EpisodesActivity>()
        }
    }

    private fun loadModules() {
        loadKoinModules(
            listOf(
                rickyAndMortyModule,
                networkRickyAndMortyModule,
                dataRickyAndMortyModule,
                dataModule,
                databaseModule
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(
            listOf(
                rickyAndMortyModule,
                networkRickyAndMortyModule,
                dataRickyAndMortyModule,
                dataModule,
                databaseModule
            )
        )
    }
}
