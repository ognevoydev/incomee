package com.incomee.incomee.presentation.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.incomee.incomee.R
import com.incomee.incomee.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        disableBottomBarTooltips()
        val navController = this.findNavController(R.id.fragment_container)
        binding.bottomNavigationBar.setupWithNavController(navController)
        binding.bottomNavigationBar.selectedItemId = (R.id.operationsFragment)

    }

    private fun disableBottomBarTooltips() {
        binding.bottomNavigationBar.menu.forEach {
                binding.bottomNavigationBar.findViewById<View>(it.itemId).setOnLongClickListener {
                    true
                }
            }
    }
}