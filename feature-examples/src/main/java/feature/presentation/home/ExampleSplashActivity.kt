package feature.presentation.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.feature_examples.R
import com.example.feature_examples.databinding.ActivitySplashBinding

/**
 * Responsible just for make a splash activity (presentation screen to the user)
 */
@SuppressLint("CustomSplashScreen")
class ExampleSplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Setting an animation that, starts with the content almost invisible and progressively
         * sets total visibility to this content
         */
        binding.mainContent.startAnimation(

            /**
             * press CTRL+left-click in the splash_fade to navigate inside of R.anim.splash_fade
             */
            AnimationUtils.loadAnimation(this, R.anim.splash_fade)
        )

        /**
         * We use this class Handler to set the content to be show after this splash activity
         * and we say to the Handler for how log this presentation screen will be shown,
         * right after this duration we automatically close this activity
         * and starts the next activity one
         */
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this, ExamplesHomeActivity::class.java))
                finish()
            },
            SPLASH_DURATION
        )
    }

    companion object {
        /**
         * 2000L is equal to 2 seconds
         * Our splash screen will be shown for 2 seconds only.
         * OBS.: You can change this duration with how long you want,
         * just declare the value as a Long
         */
        const val SPLASH_DURATION = 2000L
    }
}
