package feature.app.presentation

import androidx.annotation.StringRes
import feature.app.FeatureFlag
import feature.multimoduleapp.R

internal data class FeaturePresentation(
    @StringRes val title: Int,
    val featureFlag: FeatureFlag,
    val featureUrlImage: String?
) {
    companion object {
        operator fun invoke(flag: FeatureFlag) =
            FeaturePresentation(
                title = defineTitle(flag),
                featureFlag = flag,
                featureUrlImage = defineUrlImage(flag)
            )

        private fun defineUrlImage(flag: FeatureFlag): String? {
            return when (flag) {
                FeatureFlag.RICKY_AND_MORTY -> RICKY_FEATURE_IMAGE
                FeatureFlag.BOOKS -> BOOKS_FEATURE_IMAGE
                FeatureFlag.NEWS -> NEWS_FEATURE_IMAGE
                FeatureFlag.DOGS -> DOGS_FEATURE_IMAGE
                FeatureFlag.BILLS_TO_PAY -> BILLS_TO_PAY_FEATURE_IMAGE
                FeatureFlag.GAS_CALCULATOR -> GAS_CALCULATOR_FEATURE_IMAGE
                FeatureFlag.EXAMPLES -> EXAMPLES_FEATURE_IMAGE
                FeatureFlag.COIN_CONVERSION -> COIN_CONVERSION_FEATURE_IMAGE
                FeatureFlag.JSON_PLACE_HOLDER -> JSON_PLACE_HOLDER_FEATURE_IMAGE
                FeatureFlag.MARVEL_API -> MARVEL_API_FEATURE_IMAGE
            }
        }

        private fun defineTitle(flag: FeatureFlag) =
            when (flag) {
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
                FeatureFlag.COMPOSING -> R.string.home_dashboard_presentation_title_compose
                FeatureFlag.MARVEL_API -> R.string.home_dashboard_presentation_title_marvel_api
            }

        private const val RICKY_FEATURE_IMAGE = "https://images.tcdn.com.br/img/img_prod/697730" +
            "/adesivo_lateral_vidro_caminhao_carro_decorativo_rick_and_morty_1147486360_1_" +
            "20201210150106.jpg"
        private const val NEWS_FEATURE_IMAGE = "https://encrypted-tbn0.gstatic.com/images?q=tbn" +
            ":ANd9GcTw7HjpHNuzVssA9WGGtdCI0kC6gnLmjbMVuw&usqp=CAU"
        private const val BOOKS_FEATURE_IMAGE = "https://static.scientificamerican.com/sciam" +
            "/cache/file/1DDFE633-2B85-468D-B28D05ADAE7D1AD8_source.jpg?w=590&h=800&D80F3" +
            "D79-4382-49FA-BE4B4D0C62A5C3ED"
        private const val DOGS_FEATURE_IMAGE = "https://post.medicalnewstoday.com/wp-content" +
            "/uploads/sites/3/2020/02/322868_1100-800x825.jpg"
        private const val BILLS_TO_PAY_FEATURE_IMAGE = "https://blog.softwaregeo.com.br/wp-cont" +
            "ent/uploads/2018/07/contasapagarereceberparaescolas.png"
        private const val GAS_CALCULATOR_FEATURE_IMAGE = "https://cdn.autopapo.com.br/box/uploa" +
            "ds/2020/07/10220948/combustivel_caro.jpg"
        private const val EXAMPLES_FEATURE_IMAGE = "https://www.ufrgs.br/datathon/brainstorm.png"
        private const val COIN_CONVERSION_FEATURE_IMAGE = "https://w7.pngwing.com/pngs/781/728/" +
            "png-transparent-finance-currency-converter-bank-money-bank-orange-payment-logo.png"
        private const val JSON_PLACE_HOLDER_FEATURE_IMAGE = "https://studiovisual.com.br/wp-c" +
            "ontent/uploads/2021/08/o_que_e_post_Prancheta-1-copia-4-1024x400-1.jpg"
        private const val MARVEL_API_FEATURE_IMAGE = "https://upload.wikimedia.org/wikipedia" +
            "/commons/thumb/b/b9/Marvel_Logo.svg/800px-Marvel_Logo.svg.png"
    }
}
