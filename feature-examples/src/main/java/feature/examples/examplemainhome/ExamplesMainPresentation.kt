package feature.examples.examplemainhome

import androidx.annotation.StringRes
import com.example.feature_examples.R

internal data class ExamplesMainPresentation(
    @StringRes val title: Int,
    val exampleFlag: ExampleFlag
) {
    companion object {
        operator fun invoke(flag: ExampleFlag) =
            ExamplesMainPresentation(
                title = defineTitle(flag),
                exampleFlag = flag
            )

        private fun defineTitle(flag: ExampleFlag) =
            when (flag) {
                ExampleFlag.SIMPLE_RECYCLER_VIEW -> R.string.example_flag_simple_recycler_view
                ExampleFlag.SCREENS_NAVIGATION -> R.string.example_flag_screens_navigation
                ExampleFlag.API_REQUEST -> R.string.example_flag_api_request
            }
    }
}
