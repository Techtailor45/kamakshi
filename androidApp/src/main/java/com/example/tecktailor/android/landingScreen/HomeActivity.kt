package com.example.tecktailor.android.landingScreen

import android.os.Bundle
import androidx.navigation.NavController
import com.example.tecktailor.android.common.base.BaseActivity
import com.example.tecktailor.android.databinding.ActivityHomeBinding
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.tecktailor.android.R

class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding

     private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        if (navHostFragment == null) {
            // Add debug log if NavHostFragment is null
            throw NullPointerException("NavHostFragment is null")
        } else {
            mNavController = navHostFragment.navController
            mNavController.setGraph(R.navigation.nav_graph_home)
            binding.bottomNavigationView.setupWithNavController(mNavController)
        }
    }
}
