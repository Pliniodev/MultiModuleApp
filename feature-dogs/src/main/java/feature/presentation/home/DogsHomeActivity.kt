package feature.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import feature.dogsModule
import feature.dataDogsModule
import feature.feature_dogs.databinding.ActivityDogsHomeBinding
import feature.networkDogsModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class DogsHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDogsHomeBinding
    private val viewModel: DogsHomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogsHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadModules()
        onEnterActivity()
    }

    private fun loadModules() {
        loadKoinModules(
            listOf(
                networkDogsModule,
                dataDogsModule,
                dogsModule
            )
        )
    }

    private fun onEnterActivity() {
        viewModel.getApi(TEST_PAGE)
        observers()
    }

    private fun observers() {
        viewModel.breeds.observe(this, { breeds ->
            binding.test.text = breeds
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(
            listOf(
                networkDogsModule,
                dataDogsModule,
                dogsModule
            )
        )
    }

    companion object {
        const val TEST_PAGE = 1
    }
}
