package com.incomee.incomee.di

import android.content.Context
import com.incomee.incomee.data.repository.OperationTypeFilterRepositoryImpl
import com.incomee.incomee.data.repository.storage.FilterStorage
import com.incomee.incomee.data.repository.storage.OperationTypeFilterStorage
import com.incomee.incomee.domain.repository.OperationTypeFilterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideOperationTypeFilterRepository(filterStorage: FilterStorage) : OperationTypeFilterRepository {
        return OperationTypeFilterRepositoryImpl(filterStorage = filterStorage)
    }

    @Singleton
    @Provides
    fun provideFilterStorage(@ApplicationContext context: Context) : FilterStorage {
        return OperationTypeFilterStorage(context = context)
    }

}