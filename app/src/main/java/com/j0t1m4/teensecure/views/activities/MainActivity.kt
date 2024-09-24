package com.j0t1m4.teensecure.views.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.appbar.MaterialToolbar
import com.j0t1m4.teensecure.R
import com.j0t1m4.teensecure.databinding.ActivityMainBinding
import com.j0t1m4.teensecure.views.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            Timber.tag(ActivityMainBinding::class.java.simpleName)
            setContentView(root)
        }

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(), fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        setupToolbar()
        navController.enableOnBackPressed(true)
        NavigationUI.setupWithNavController(findViewById<MaterialToolbar>(R.id.toolbar), navController, appBarConfiguration)
    }

    private fun setupToolbar() {
        val toolBar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolBar.setNavigationIconTint(Color.BLACK)
        toolBar.setTitleTextColor(Color.BLACK)
        toolBar.setNavigationIconTint(Color.BLACK)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolBar.title = title
    }

    fun setToolbarBgColor(color: Int) {
        val toolBar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolBar.setBackgroundResource(color)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection.
        return when (item.itemId) {
            R.id.profile -> {
                navController.navigate(R.id.action_global_fragmentProfile)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

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
        fun open(context: Context) = context.startActivity(
            Intent(context, MainActivity::class.java)
        )
    }
}