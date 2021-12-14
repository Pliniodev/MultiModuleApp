package feature.app.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import feature.app.FeatureFlag
import feature.app.presentation.FeaturePresentation
import feature.app.presentation.HomeAdapter
import feature.app.presentation.UnderConstructionFeatActivity
import feature.commons.utils.navigateTo
import feature.conversordemoedas.CoinConversionActivity
import feature.dogs.presentation.home.DogsHomeActivity
import feature.examples.recyclerview.presentation.home.ExampleSplashActivity
import feature.gas_calculator.GasCalculatorHomeActivity
import feature.jsonplaceholder.presentation.home.JsonPlaceHolderHomeActivity
import feature.marvelapi.presentation.home.activity.MarvelHomeActivity
import feature.multimoduleapp.databinding.ActivityMainHomeBinding
import feature.newsapi.presentation.home.NewsApiHomeActivity
import feature.ricky.presentation.home.RickyHomeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class MainHomeActivity : AppCompatActivity() {
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
        FeatureFlag.RICKY_AND_MORTY -> navigateTo<RickyHomeActivity>()
        FeatureFlag.EXAMPLES -> navigateTo<ExampleSplashActivity>()
        FeatureFlag.COIN_CONVERSION -> navigateTo<CoinConversionActivity>()
        FeatureFlag.BOOKS -> navigateTo<UnderConstructionFeatActivity>()
        FeatureFlag.NEWS -> navigateTo<NewsApiHomeActivity>()
        FeatureFlag.GAS_CALCULATOR -> navigateTo<GasCalculatorHomeActivity>()
        FeatureFlag.DOGS -> navigateTo<DogsHomeActivity>()
        FeatureFlag.BILLS_TO_PAY -> navigateTo<UnderConstructionFeatActivity>()
        FeatureFlag.JSON_PLACE_HOLDER -> navigateTo<JsonPlaceHolderHomeActivity>()
        FeatureFlag.MARVEL_API -> navigateTo<MarvelHomeActivity>()
    }
}
