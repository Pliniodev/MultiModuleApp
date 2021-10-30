package feature.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_rickyandmorty.databinding.ActivityMainBinding
import feature.dataRickyAndMortyModule
import feature.networkRickyAndMortyModule
import feature.presentation.viewmodel.RickyAndMortyHomeViewModel
import feature.rickyAndMortyModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class RickyAndMortyHomeActivity : AppCompatActivity() {
    private val viewModel: RickyAndMortyHomeViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadModules()

        onEnterActivity()
        viewModel.getEpisodes()
    }

    private fun onEnterActivity() {
        setupViews()
    }

    private fun setupViews() {
//        binding.buttonEpisodes.setOnClickListener {
////            navigateTo() TODO navigateToepisodes
//        }
    }

    private fun navigateTo(activity: Class<RickyAndMortyHomeActivity>) {
        startActivity(Intent(this, activity))
    }

    private fun loadModules() {
        loadKoinModules(
            listOf(
                rickyAndMortyModule,
                networkRickyAndMortyModule,
                dataRickyAndMortyModule
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(rickyAndMortyModule)
    }
}