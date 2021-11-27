package featuredogs.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import feature.feature_dogs.databinding.ActivityDogsHomeBinding
import featuredogs.dataDogsModule
import featuredogs.dogsModule
import featuredogs.networkDogsModule
import featuredogs.presentation.adapter.DogsAdapter
import featuredogs.presentation.details.DogDetailActivity
import featuredogs.presentation.model.BreedPresentation
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
        viewModel.getBreedsList(TEST_PAGE)
        observers()
    }

    private fun observers() {
        viewModel.breeds.observe(
            this,
            { breedPresentations -> breedPresentations?.let { setAdapter(it) } }
        )
    }

    private fun setAdapter(breedPresentations: List<BreedPresentation>) {
        val adapter = DogsAdapter(
            context = this,
            breedPresentations = breedPresentations,
            action = { breed -> aggregateAndGoToDetails(breed) }
        )
        binding.dogsRecycler.adapter = adapter
    }

    private fun aggregateAndGoToDetails(breedPresentation: BreedPresentation) {
        val intent = Intent(this, DogDetailActivity::class.java)
        intent.putExtra(BREED_PRESENTATION, breedPresentation)
        startActivity(intent)
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

    private companion object {
        const val TEST_PAGE = 1
        const val BREED_PRESENTATION = "breed_presentation"
    }
}
