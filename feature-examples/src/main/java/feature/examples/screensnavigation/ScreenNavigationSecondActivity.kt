package feature.examples.screensnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_examples.databinding.ActivityScreensNavigationSecondBinding
import feature.examples.screensnavigation.model.StrangePerson

internal class ScreenNavigationSecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScreensNavigationSecondBinding
    // Other ways to get intent
    // private val firstIntent get() = intent.getStringExtra(FIRST_INTENT).orEmpty()
    // prvate val secondIntent get() = intent.getStringExtra(SECOND_INTENT) ?: 0
    private val thirdIntent get() = intent?.extras

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreensNavigationSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        binding.intentTv.text = getTheIntent()
    }

    private fun getTheIntent(): String {
        val result = thirdIntent?.let { bundle ->
            when {
                bundle[FIRST_INTENT] != null -> bundle.getString(FIRST_INTENT)
                bundle[SECOND_INTENT] != null || bundle[THIRD_INTENT] != null -> {
                    val second = bundle.getInt(SECOND_INTENT)
                    val person = bundle.getSerializable(THIRD_INTENT) as? StrangePerson
                    printIntent(second, person)
                }
                else -> "Não chegou nada aqui"
            }
        }
        return result.orEmpty()
    }

    private fun printIntent(second: Int, person: StrangePerson?): String {
        return """ | Segunda intent (Int): $second 
            |   
            | Objeto enviado:   
            | Nome: ${person?.name}
            | Idade: ${person?.age}
            | Rua: ${person?.address?.street}
            | CEP: ${person?.address?.postalCode}
        """.trimMargin()
    }

    companion object {
        const val FIRST_INTENT = "first.intent"
        const val SECOND_INTENT = "second.intent"
        const val THIRD_INTENT = "third.intent"
    }
}
