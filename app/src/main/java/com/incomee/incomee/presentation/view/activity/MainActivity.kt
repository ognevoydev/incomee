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

class MainActivity : AppCompatActivity() {

    private val b: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        disableBottomBarTooltips()
        val navController = this.findNavController(R.id.fragment_container)
        b.bottomNavigationBar.setupWithNavController(navController)
        b.bottomNavigationBar.selectedItemId = (R.id.operationsFragment)

    }

    private fun disableBottomBarTooltips() {
        b.bottomNavigationBar.menu.forEach {
                b.bottomNavigationBar.findViewById<View>(it.itemId).setOnLongClickListener {
                    true
                }
            }
    }
}