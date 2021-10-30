package feature.presentation.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.home.databinding.ActivityHomeBinding
import feature.presentation.activity.ExamplesHomeActivity
import feature.presentation.FeatureFlag
import feature.presentation.FeatureFlag.EXAMPLES
import feature.presentation.FeatureFlag.RICKY_AND_MORTY
import feature.presentation.FeaturePresentation
import feature.presentation.activity.RickyAndMortyHomeActivity
import feature.presentation.HomeAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Os comentário nessa feature servem para padronizar e exemplificar o que será feito nas outras features
 * No app os comentário só serão bem vindos caso sejam de EXTREMA NECESSIDADE.
 * O ideal é que o código seja auto explicativo.
 */

class HomeActivity : AppCompatActivity() {
    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onEnterActivity()
    }

    /**
     * Função padrão para todas as activities, fragments ... telas no geral.
     * Centraliza todas as funções que devem acontecer quando a tela é iniciada.
     */
    private fun onEnterActivity() {
//        setupViews() //quando necessária
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
        viewModel.featureList.observe(this, { featurePresentations ->
            setAdapter(featurePresentations)
        })
    }

    /**
     * Inicializa o adapter
     * featurePresentation é a lista de features
     * action: Função que realiza algo após o click no item do Recycler
     */
    private fun setAdapter(featurePresentations: List<FeaturePresentation>) {
        val adapter = HomeAdapter(
            presentations = featurePresentations,
            action = { featureFlag -> navigateTo(startNavigation(featureFlag)) }
        )
        binding.homeRecycler.adapter = adapter
    }

    /**
     * Caso necessário
     *Centraliza tudo que as views devem fazer ao serem acionadas(Caso sejam),
     * exemplo: Listeners
     */
//    private fun setupViews() {}

    /**
     * Navega de acordo com o item do recycler clicado
     */
    private fun startNavigation(featureFlag: FeatureFlag) = when(featureFlag) {
        RICKY_AND_MORTY -> RickyAndMortyHomeActivity::class.java
        EXAMPLES -> ExamplesHomeActivity::class.java
        FeatureFlag.CHAT -> TODO()
        FeatureFlag.BOOKS -> TODO()
        FeatureFlag.NEWS -> TODO()
        FeatureFlag.GAS_CALCULATOR -> TODO()

    }

    /**
     * Centraliza navegação
     */
    private fun navigateTo(activity: Class<out AppCompatActivity>) {
        startActivity(Intent(this, activity))
    }

    /**
     * Ao fazer o xml das telas certifique-se de centralizar as strings no arquivo strings.xml
     * As strings ficarão no arquivo strings de cada módulo para ajudar a organizar.
     * E dimensões (exceto tamanho de fonte) em dimens.xml na feature commons
     * Cores também ficarão centralizadas em colors.xml da feature commons
     */

    /**
     * Quando adicionar uma activity certifique-se que ela estará no arquivo manifest do módulo App
     * Ainda vou descobrir uma forma de não haver arquivo manifest em cada módulo e sim sempre no módulo App
     */

}