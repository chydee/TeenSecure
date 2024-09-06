package com.j0t1m4.teensecure.views.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.databinding.ActivityWelcomeBinding
import com.j0t1m4.teensecure.views.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class WelcomeActivity : BaseActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater).apply {
            Timber.tag(WelcomeActivity::class.java.simpleName)
            setContentView(root)
        }

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_welcome) as NavHostFragment
        navController = navHostFragment.navController

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    @Deprecated("Deprecated in Java", ReplaceWith("super.onBackPressed()", "androidx.appcompat.app.AppCompatActivity"))
    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_welcome)

        if (currentFragment !is NavHostFragment) {
            super.onBackPressed()
            return
        }

        if (!navController.popBackStack()) {
            super.onBackPressed()
        }
    }

    companion object {
        fun open(context: Context) =
            context.startActivity(
                Intent(context, WelcomeActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                }
            )
    }
}