package feature.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import feature.multimoduleapp.databinding.ActivityMainHomeBinding
import feature.presentation.FeatureFlag
import feature.presentation.FeatureFlag.EXAMPLES
import feature.presentation.FeatureFlag.RICKY_AND_MORTY
import feature.presentation.FeaturePresentation
import feature.presentation.HomeAdapter
import feature.utils.navigateTo
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Os comentário nessa feature servem para padronizar e exemplificar o que será feito nas outras features
 * No app os comentário só serão bem vindos caso sejam de EXTREMA NECESSIDADE.
 * O ideal é que o código seja auto explicativo.
 */

class MainHomeActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: ActivityMainHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onEnterActivity()
    }

    /**
     * Função padrão para todas as activities, fragments ... telas no geral.
     * Centraliza todas as funções que devem acontecer quando a tela é iniciada.
     */
    private fun onEnterActivity() {
        populateViews()
        observers()
    }

    /**
     * Chama a função que busca a lista de apresentações para o recycler
     */
    private fun populateViews() {
        viewModel.getFeaturesList()
    }

    /**
     * Observa o viewModel
     */
    private fun observers() {
        viewModel.featureList.observe(
            this,
            { featurePresentations ->
                setAdapter(featurePresentations)
            }
        )
    }

    /**
     * Inicializa o adapter
     * featurePresentation é a lista de features
     * action: Função que realiza algo após o click no item do Recycler
     */
    private fun setAdapter(featurePresentations: List<FeaturePresentation>) {
        val adapter = HomeAdapter(
            presentations = featurePresentations,
            action = { featureFlag -> startNavigation(featureFlag) }
        )
        binding.homeRecycler.adapter = adapter
    }

    /**
     * Caso necessário
     *Centraliza tudo que as views devem fazer ao serem acionadas(Caso sejam),
     * exemplo: Listeners
     */

    /**
     * Navega de acordo com o clique no item do recycler
     */
    private fun startNavigation(featureFlag: FeatureFlag) = when (featureFlag) {
        RICKY_AND_MORTY -> navigateTo<RickyHomeActivity>()
        EXAMPLES -> navigateTo<ExamplesHomeActivity>()
        FeatureFlag.BOOKS -> TODO()
        FeatureFlag.NEWS -> TODO()
        FeatureFlag.GAS_CALCULATOR -> TODO()
        FeatureFlag.DOGS -> TODO()
        FeatureFlag.BILLS_TO_PAY -> TODO()
    }

    /**
     * Ao fazer o xml das telas certifique-se de centralizar as strings no arquivo strings.xml
     * As strings ficarão no arquivo strings de cada módulo para ajudar a organizar.
     * E dimensões (exceto tamanho de fonte) em dimens.xml na feature commons
     * Cores também ficarão centralizadas em colors da feature commons
     */
}
