package com.incomee.incomee.presentation.view.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.TooltipCompat
import androidx.core.view.forEach
import androidx.fragment.app.add
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.incomee.incomee.R
import com.incomee.incomee.databinding.ActivityMainBinding
import com.incomee.incomee.presentation.view.fragment.OperationsFragment

class MainActivity : AppCompatActivity() {

    private val b: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = this.findNavController(R.id.fragment_container_view)
        b.bottomNavigationBar.setupWithNavController(navController)

        disableBottomBarTooltips()
    }

    fun disableBottomBarTooltips() {
        b.bottomNavigationBar
            .menu.forEach {
                b.bottomNavigationBar.findViewById<View>(it.itemId).setOnLongClickListener {
                    true
                }
            }
    }
}