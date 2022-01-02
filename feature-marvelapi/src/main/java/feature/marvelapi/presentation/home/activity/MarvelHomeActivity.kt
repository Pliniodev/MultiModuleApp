package feature.marvelapi.presentation.home.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import feature.marvelapi.R
import feature.marvelapi.databinding.ActivityMarvelHomeBinding

class MarvelHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMarvelHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarvelHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onEnter()
    }

    private fun onEnter() {
        supportActionBar?.hide()

        setUpNavigation()
    }

    private fun setUpNavigation() {

        val supportFM = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment

        val navController = supportFM.navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.charactersFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNav.setupWithNavController(navController)
    }
}
