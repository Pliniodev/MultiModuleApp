package feature.marvelapi.presentation.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import feature.marvelapi.R
import feature.marvelapi.databinding.ActivityMarvelSplashScreenBinding
import feature.marvelapi.presentation.notification.MarvelNotificationManager

@SuppressLint("CustomSplashScreen")
class MarvelSplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMarvelSplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarvelSplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onEnter()
    }

    private fun onEnter() {
        supportActionBar?.hide()
        initSplashScreen()

        val intent = Intent(this, MarvelHomeActivity::class.java)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent)
            MarvelNotificationManager().createNotificationChannel(this)
        }
    }

    private fun initSplashScreen() {

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
