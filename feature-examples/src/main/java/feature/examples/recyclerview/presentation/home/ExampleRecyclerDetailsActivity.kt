package feature.examples.recyclerview.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_examples.databinding.ActivityRecyclerExampleDetailsBinding

class ExampleRecyclerDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerExampleDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerExampleDetailsBinding.inflate(layoutInflater)
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
    companion object {
        const val INTENT_DETAILS = "INTENT_DETAILS"
    }
}
