package com.incomee.incomee.di

import android.content.Context
import android.content.res.Resources
import com.incomee.incomee.R
import com.incomee.incomee.domain.model.Category
import com.incomee.incomee.domain.model.OperationTypeFilter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideResources(@ApplicationContext context: Context) : Resources {
        return context.resources
    }

    @Singleton
    @Provides
    @Named("OperationTypesList")
    fun provideOperationTypesList(res: Resources) : HashMap<String, OperationTypeFilter> {
        return hashMapOf(
            OperationTypeFilter.OperationType.INCOME.value to
                    OperationTypeFilter(res.getString(R.string.income), OperationTypeFilter.OperationType.INCOME),
            OperationTypeFilter.OperationType.EXPENSE.value to
                    OperationTypeFilter(res.getString(R.string.expense), OperationTypeFilter.OperationType.EXPENSE),
            OperationTypeFilter.OperationType.TRANSFER.value to
                    OperationTypeFilter(res.getString(R.string.transfer), OperationTypeFilter.OperationType.TRANSFER),
        )
    }

    @Singleton
    @Provides
    @Named("CategoriesList")
    fun provideCategoriesList(res: Resources) : ArrayList<Category> {
        return arrayListOf(
            Category(res.getString(R.string.category_empty), R.drawable.category_empty_ic),
            Category(res.getString(R.string.category_products), R.drawable.category_products_ic),
            Category(res.getString(R.string.category_car), R.drawable.category_car_ic),
            Category(res.getString(R.string.category_clothes), R.drawable.category_clothes_ic),
            Category(res.getString(R.string.category_internet), R.drawable.category_internet_ic),
            Category(res.getString(R.string.category_cafe), R.drawable.category_cafe_ic),
            Category(res.getString(R.string.category_education), R.drawable.category_education_ic),
            Category(res.getString(R.string.category_entertainment), R.drawable.category_entertainment_ic),
            Category(res.getString(R.string.category_gifts), R.drawable.category_gifts_ic),
            Category(res.getString(R.string.category_tech), R.drawable.category_tech_ic),
            Category(res.getString(R.string.category_medicine), R.drawable.category_medicine_ic),
            Category(res.getString(R.string.category_home), R.drawable.category_home_ic),
            Category(res.getString(R.string.category_children), R.drawable.category_children_ic),
            Category(res.getString(R.string.category_pets), R.drawable.category_pets_ic),
            Category(res.getString(R.string.category_sport), R.drawable.category_sport_ic),
            Category(res.getString(R.string.category_transport), R.drawable.category_transport_ic),
            Category(res.getString(R.string.category_travel), R.drawable.category_travel_ic)
        )
    }

}