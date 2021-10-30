package feature.presentation

import androidx.annotation.StringRes
import com.example.home.R

internal data class FeaturePresentation(
    @StringRes val title: Int,
    val featureFlag: FeatureFlag
) {
    companion object {
        operator fun invoke(flag: FeatureFlag) =
            FeaturePresentation(
                title = defineTitle(flag),
                featureFlag = flag
            )

        private fun defineTitle(tag: FeatureFlag) =
            when (tag) {
                FeatureFlag.RICKY_AND_MORTY -> R.string.home_rickyAndMorty_presentation_title_ricky_and_morty
                FeatureFlag.CHAT -> R.string.home_rickyAndMorty_presentation_title_chat
                FeatureFlag.BOOKS -> R.string.home_rickyAndMorty_presentation_title_books
                FeatureFlag.NEWS -> R.string.home_rickyAndMorty_presentation_title_news
                FeatureFlag.GAS_CALCULATOR -> R.string.home_rickyAndMorty_presentation_title_gas_calculator
                FeatureFlag.EXAMPLES -> R.string.home_dashboard_presentation_title_examples
            }
    }
}
