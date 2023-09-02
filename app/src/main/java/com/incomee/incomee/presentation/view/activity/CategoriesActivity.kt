package com.incomee.incomee.presentation.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.incomee.incomee.R
import com.incomee.incomee.databinding.ActivityCategoriesBinding
import com.incomee.incomee.domain.model.Category
import com.incomee.incomee.presentation.adapter.BottomDividerDecorator
import com.incomee.incomee.presentation.adapter.CategoriesAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class CategoriesActivity : AppCompatActivity() {

    private val binding: ActivityCategoriesBinding by viewBinding()

    @Inject
    @Named("CategoriesList")
    lateinit var categoriesList: ArrayList<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        binding.categoriesRecyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            addItemDecoration(BottomDividerDecorator(context))
            adapter = CategoriesAdapter(categoriesList)
        }

        binding.backIconLayout.setOnClickListener {
            binding.backIcon.performClick()
            finish()
        }
    }
}