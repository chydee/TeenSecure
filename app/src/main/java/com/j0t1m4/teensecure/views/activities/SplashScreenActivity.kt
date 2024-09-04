package com.j0t1m4.teensecure.views.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        Timber.tag(SplashScreenActivity::class.simpleName.toString())
        val splashScreen = installSplashScreen()
        // Set up the splash screen exit animation.
        splashScreen.setOnExitAnimationListener { splashScreenViewProvider ->
            val splashScreenView = splashScreenViewProvider.view

            // Create fade out and scale up animation.
            splashScreenView.animate().alpha(0f).scaleX(1.2f).scaleY(1.2f).setDuration(2000).withEndAction {
                // After animation ends, remove splash screen.
                splashScreenViewProvider.remove()
                WelcomeActivity.open(this)
            }.start()
        }
    }


}