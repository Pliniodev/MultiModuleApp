package feature.app

import androidx.annotation.StringRes
import feature.multimoduleapp.R

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
                FeatureFlag.BOOKS -> R.string.home_rickyAndMorty_presentation_title_books
                FeatureFlag.NEWS -> R.string.home_rickyAndMorty_presentation_title_news
                FeatureFlag.GAS_CALCULATOR -> R.string.home_rickyAndMorty_presentation_title_gas_calculator
                FeatureFlag.EXAMPLES -> R.string.home_dashboard_presentation_title_examples
                FeatureFlag.DOGS -> R.string.home_dashboard_presentation_title_dogs
                FeatureFlag.BILLS_TO_PAY -> R.string.home_dashboard_presentation_title_bills_to_pay
                FeatureFlag.COIN_CONVERSION -> {
                    R.string.home_dashboard_presentation_title_coin_conversion
                }
                FeatureFlag.JSON_PLACE_HOLDER -> {
                    R.string.home_dashboard_presentation_title_json_place_holder
                }

            }
    }
}
