package feature.marvelapi.presentation.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import feature.marvelapi.R
import feature.marvelapi.databinding.ActivityMarvelSplashScreenBinding
import feature.marvelapi.presentation.home.activity.MarvelHomeActivity

@SuppressLint("CustomSplashScreen")
class MarvelSplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMarvelSplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarvelSplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onEnter()
    }

    private fun onEnter(){
        initSplashScreen()
    }

    private fun initSplashScreen(){

        binding.mainContent.startAnimation(AnimationUtils.loadAnimation(this, R.anim.splash_fade))

        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this, MarvelHomeActivity::class.java))
                finish()
            },
            SPLASH_DURATION
        )
    }

    companion object {
        const val SPLASH_DURATION = 3000L
    }
}
