package com.j0t1m4.teensecure.views.common

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.data.SharedPreferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {
    @Inject
    open lateinit var preferences: SharedPreferences

    fun setAppBarTitle(title: String) {
        findViewById<MaterialToolbar>(R.id.toolbar).title = title
    }
}