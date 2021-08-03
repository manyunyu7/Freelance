package com.eva.dikejar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.eva.dikejar.databinding.ActivityNavigationControllerBinding

class NavigationControllerActivity : AppCompatActivity() {


    val binding by lazy { ActivityNavigationControllerBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_main_controller)
        setupActionBarWithNavController(navController)


    }
}