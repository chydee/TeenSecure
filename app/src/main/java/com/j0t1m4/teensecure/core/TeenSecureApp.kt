package com.j0t1m4.teensecure.core

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.j0t1m4.teensecure.data.SharedPreferences
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class TeenSecureApp : Application(), LifecycleObserver {
    @Inject
    lateinit var pref: SharedPreferences

    override fun onCreate() = super.onCreate().also {
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
        /* if (BuildConfig.DEBUG) {
             plant(DebugTree())
         }*/
    }
}