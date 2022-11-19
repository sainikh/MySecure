package com.example.mysecure

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mysecure.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mNavHostFragment: NavHostFragment
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //NavHostFragment setup for
         mNavHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController =  mNavHostFragment.navController

        //App BarConfiguration helps you to set different Action bar for different fragment
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.chats_Fragment,R.id.camera_Fragment,R.id.contacts_Fragment,R.id.settings_Fragment))

        //here we wrap navcontroller with BarConfiguration
        setupActionBarWithNavController(navController,appBarConfiguration)
        //bottom setupWithController is the main show runner here
       binding.bottomNavigationView.setupWithNavController(navController)


    }
}