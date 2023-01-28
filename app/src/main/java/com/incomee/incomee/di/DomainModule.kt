package com.incomee.incomee.di

import android.content.Context
import com.incomee.incomee.data.repository.OperationTypeFilterRepositoryImpl
import com.incomee.incomee.data.repository.storage.FilterStorage
import com.incomee.incomee.data.repository.storage.OperationTypeFilterStorage
import com.incomee.incomee.domain.repository.OperationTypeFilterRepository
import com.incomee.incomee.domain.usecase.ClearOperationTypeFiltersUseCase
import com.incomee.incomee.domain.usecase.GetOperationTypeFiltersUseCase
import com.incomee.incomee.domain.usecase.RemoveOperationTypeFilterUseCase
import com.incomee.incomee.domain.usecase.SaveOperationTypeFilterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideSaveOperationTypeFilterUseCase(filterRepository: OperationTypeFilterRepository) : SaveOperationTypeFilterUseCase {
        return SaveOperationTypeFilterUseCase(operationTypeFilterRepository = filterRepository)
    }

    @Provides
    fun provideRemoveOperationTypeFilterUseCase(filterRepository: OperationTypeFilterRepository) : RemoveOperationTypeFilterUseCase {
        return RemoveOperationTypeFilterUseCase(operationTypeFilterRepository = filterRepository)
    }

    @Provides
    fun provideClearOperationTypeFilterUseCase(filterRepository: OperationTypeFilterRepository) : ClearOperationTypeFiltersUseCase {
        return ClearOperationTypeFiltersUseCase(operationTypeFilterRepository = filterRepository)
    }

    @Provides
    fun provideGetOperationTypeFiltersUseCase(filterRepository: OperationTypeFilterRepository) : GetOperationTypeFiltersUseCase {
        return GetOperationTypeFiltersUseCase(operationTypeFilterRepository = filterRepository)
    }

}