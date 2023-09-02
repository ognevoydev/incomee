package com.incomee.incomee.di

import com.incomee.incomee.domain.repository.OperationTypeFilterRepository
import com.incomee.incomee.domain.usecase.ClearOperationTypeFiltersUseCase
import com.incomee.incomee.domain.usecase.GetOperationTypeFiltersUseCase
import com.incomee.incomee.domain.usecase.ToggleOperationTypeFilterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideToggleOperationTypeFilterUseCase(filterRepository: OperationTypeFilterRepository) : ToggleOperationTypeFilterUseCase {
        return ToggleOperationTypeFilterUseCase(operationTypeFilterRepository = filterRepository)
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