package feature.app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import feature.multimoduleapp.databinding.ActivityUnderConstructionFeatBinding

internal class UnderConstructionFeatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUnderConstructionFeatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnderConstructionFeatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backButton.setOnClickListener { finish() }
    }
}
