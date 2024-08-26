package com.j0t1m4.teensecure.views.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.data.SharedPreferences
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity(R.layout.activity_splash_screen) {

    @Inject
    lateinit var settingContext: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        Timber.tag(SplashScreenActivity::class.simpleName.toString())
        closeActivity()
    }

    private fun closeActivity() {
        val mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper())
        mainThreadHandler.postDelayed(
            {
                WelcomeActivity.open(this)
            }, 3000
        )
    }

}