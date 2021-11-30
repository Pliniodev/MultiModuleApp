package feature.dogs.presentation.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import feature.dogs.presentation.model.BreedPresentation
import feature.feature_dogs.R
import feature.feature_dogs.databinding.ActivityDogDetailBinding

internal class DogDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDogDetailBinding
    private val breedPresentation
        get() = intent.getSerializableExtra(BREED_PRESENTATION) as? BreedPresentation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onEnterActivity()
    }

    private fun onEnterActivity() {
        renderScreen()
    }

    private fun renderScreen() {
        binding.apply {
            breedPresentation?.let { breedPresentation ->
                breedTitle.text = breedPresentation.name
                Glide.with(this@DogDetailActivity)
                    .load(breedPresentation.image?.url)
                    .placeholder(R.drawable.ic_baseline_portrait_24)
                    .into(breedImage)
                breedHeight.text = getString(
                    R.string.dog_details_hight_title, breedPresentation.height?.metric
                )
            }
        }
    }

    private companion object {
        const val BREED_PRESENTATION = "breed_presentation"
    }
}
