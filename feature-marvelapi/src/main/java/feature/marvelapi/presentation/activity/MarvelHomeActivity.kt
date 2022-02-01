package feature.marvelapi.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
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
                R.id.charactersFragment,
                R.id.comicsFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNav.setupWithNavController(navController)
    }
}
