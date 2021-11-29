package feature.dogs.presentation.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import feature.commons.utils.Aggregator
import feature.dogs.presentation.model.BreedPresentation
import feature.feature_dogs.R
import feature.feature_dogs.databinding.ActivityDogDetailBinding

internal class DogDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDogDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onEnterActivity()
    }

    private fun onEnterActivity() {
        renderScreen(retrieveDogDetails())
    }

    private fun renderScreen(dogDetails: BreedPresentation?) {
        binding.apply {
            dogDetails?.let {
                breedTitle.text = dogDetails.name
                Glide.with(this@DogDetailActivity)
                    .load(dogDetails.image?.url)
                    .placeholder(R.drawable.ic_baseline_portrait_24)
                    .into(breedImage)
                breedHeight.text = getString(
                    R.string.dog_details_hight_title, dogDetails.height?.metric
                )
            }
        }
    }

    private fun retrieveDogDetails(): BreedPresentation?  {
        val intent = intent.getSerializableExtra(BREED_PRESENTATION)as? Aggregator
        return intent?.let {
            it.data as BreedPresentation
        }
    }


    private companion object {
        const val BREED_PRESENTATION = "breed_presentation"
    }
}
