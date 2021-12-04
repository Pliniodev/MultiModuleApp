package feature.examples.examplemainhome.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_examples.databinding.ActivityExampleMainHomeBinding
import feature.commons.utils.navigateTo
import feature.examples.exampleModule
import feature.examples.examplemainhome.ExampleFlag
import feature.examples.examplemainhome.ExampleFlag.API_REQUEST
import feature.examples.examplemainhome.ExampleFlag.SCREENS_NAVIGATION
import feature.examples.examplemainhome.ExampleFlag.SIMPLE_RECYCLER_VIEW
import feature.examples.examplemainhome.ExamplesMainPresentation
import feature.examples.apiRequestJsonPlaceHolderModule
import feature.examples.apirequest.presentation.home.ExampleApiRequestActivity
import feature.examples.recyclerview.presentation.home.ExamplesRecyclerHomeActivity
import feature.examples.screensnavigation.ScreensNavigationFirstActivity
import org.koin.androidx.viewmodel.ext.android.viewModel // this must be imported manually
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

internal class ExampleMainHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExampleMainHomeBinding
    private val viewModel: ExampleMainHomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExampleMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadKoinModules(listOf(exampleModule, apiRequestJsonPlaceHolderModule))

        onEnterActivity()
    }

    private fun onEnterActivity() {
        populateViews()
        observers()
    }

    private fun observers() {
        viewModel.examples.observe(
            this,
            { examplePresentations ->
                setAdapter(examplePresentations)
            }
        )
    }

    private fun setAdapter(examplePresentations: List<ExamplesMainPresentation>) {
        val adapter = ExampleMainHomeAdapter(
            presentations = examplePresentations,
            action = { exampleFlag -> startNavigation(exampleFlag) }
        )
        binding.exampleMainHomeRecycler.adapter = adapter
    }

    private fun startNavigation(exampleFlag: ExampleFlag) = when (exampleFlag) {
        SIMPLE_RECYCLER_VIEW -> navigateTo<ExamplesRecyclerHomeActivity>()
        SCREENS_NAVIGATION -> navigateTo<ScreensNavigationFirstActivity>()
        API_REQUEST -> navigateTo<ExampleApiRequestActivity>()
    }

    private fun populateViews() {
        viewModel.getExamples()
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(listOf(exampleModule, apiRequestJsonPlaceHolderModule))
    }
}
