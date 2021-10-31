package feature.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.feature_examples.databinding.ActivityExampleDetailsBinding

class ExampleDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExampleDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExampleDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        putExtras()
    }

    /**
     * we use an intent to consume the data that we received from our home activity.
     */
    private fun putExtras() {
        binding.mainTitle.text = intent.getStringExtra(INTENT_DETAILS)
    }

    /**
     * responsible to get the data from the previous activity
     */
    companion object{
        const val INTENT_DETAILS = "INTENT_DETAILS"
    }
}