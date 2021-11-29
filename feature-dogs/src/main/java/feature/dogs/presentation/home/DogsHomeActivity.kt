package feature.dogs.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import feature.dogs.dogsModule
import feature.dogs.presentation.adapter.DogsAdapter
import feature.dogs.presentation.details.DogDetailActivity
import feature.dogs.presentation.model.BreedPresentation
import feature.feature_dogs.databinding.ActivityDogsHomeBinding
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
        loadKoinModules(listOf(dogsModule))

        onEnterActivity()
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
        unloadKoinModules(listOf(dogsModule))
    }

    private companion object {
        const val TEST_PAGE = 1
        const val BREED_PRESENTATION = "breed_presentation"
    }
}
