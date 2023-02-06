package com.incomee.incomee.di

import android.content.Context
import android.content.res.Resources
import com.incomee.incomee.R
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
    @Named("OperationTypes")
    fun provideOperationTypes(res: Resources) : HashMap<String, OperationTypeFilter> {
        return hashMapOf(
            OperationTypeFilter.OperationType.INCOME.value to
                    OperationTypeFilter(res.getString(R.string.income), OperationTypeFilter.OperationType.INCOME),
            OperationTypeFilter.OperationType.EXPENSE.value to
                    OperationTypeFilter(res.getString(R.string.expense), OperationTypeFilter.OperationType.EXPENSE),
            OperationTypeFilter.OperationType.TRANSFER.value to
                    OperationTypeFilter(res.getString(R.string.transfer), OperationTypeFilter.OperationType.TRANSFER),
        )
    }

}