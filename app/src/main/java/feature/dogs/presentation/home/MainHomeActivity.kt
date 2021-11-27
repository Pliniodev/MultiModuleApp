package feature.dogs.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import feature.commons.utils.navigateTo
import feature.examples.presentation.home.ExampleSplashActivity
import feature.multimoduleapp.databinding.ActivityMainHomeBinding
import feature.dogs.presentation.FeatureFlag
import feature.dogs.presentation.FeatureFlag.EXAMPLES
import feature.dogs.presentation.FeatureFlag.RICKY_AND_MORTY
import feature.dogs.presentation.FeaturePresentation
import feature.dogs.presentation.HomeAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainHomeActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: ActivityMainHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onEnterActivity()
    }

    private fun onEnterActivity() {
        populateViews()
        observers()
    }

    private fun populateViews() {
        viewModel.getFeaturesList()
    }

    private fun observers() {
        viewModel.featureList.observe(
            this,
            { featurePresentations ->
                setAdapter(featurePresentations)
            }
        )
    }

    private fun setAdapter(featurePresentations: List<FeaturePresentation>) {
        val adapter = HomeAdapter(
            presentations = featurePresentations,
            action = { featureFlag -> startNavigation(featureFlag) }
        )
        binding.homeRecycler.adapter = adapter
    }

    private fun startNavigation(featureFlag: FeatureFlag) = when (featureFlag) {
        RICKY_AND_MORTY -> navigateTo<RickyHomeActivity>()
        EXAMPLES -> navigateTo<ExampleSplashActivity>()
        FeatureFlag.BOOKS -> TODO()
        FeatureFlag.NEWS -> TODO()
        FeatureFlag.GAS_CALCULATOR -> TODO()
        FeatureFlag.DOGS -> navigateTo<DogsHomeActivity>()
        FeatureFlag.BILLS_TO_PAY -> TODO()
    }
}
