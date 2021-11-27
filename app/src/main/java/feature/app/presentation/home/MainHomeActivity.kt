package feature.app.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import feature.app.FeatureFlag
import feature.app.FeatureFlag.EXAMPLES
import feature.app.FeatureFlag.RICKY_AND_MORTY
import feature.app.FeatureFlag.COIN_CONVERSION
import feature.app.FeaturePresentation
import feature.app.HomeAdapter
import feature.app.presentation.UnderConstructionFeatActivity
import feature.commons.utils.navigateTo
import feature.conversordemoedas.CoinConversionActivity
import feature.examples.presentation.home.ExampleSplashActivity
import feature.multimoduleapp.databinding.ActivityMainHomeBinding
import feature.ricky.presentation.home.DogsHomeActivity
import feature.ricky.presentation.home.RickyHomeActivity
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
        COIN_CONVERSION -> navigateTo<CoinConversionActivity>()
        FeatureFlag.BOOKS -> navigateTo<UnderConstructionFeatActivity>()
        FeatureFlag.NEWS -> navigateTo<UnderConstructionFeatActivity>()
        FeatureFlag.GAS_CALCULATOR -> navigateTo<UnderConstructionFeatActivity>()
        FeatureFlag.DOGS -> navigateTo<DogsHomeActivity>()
        FeatureFlag.BILLS_TO_PAY -> navigateTo<UnderConstructionFeatActivity>()
    }
}
