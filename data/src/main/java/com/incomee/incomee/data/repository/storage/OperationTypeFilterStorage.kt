package com.incomee.incomee.data.repository.storage

import android.content.Context
import com.incomee.incomee.data.constants.DialogConstants.OPERATION_TYPES
import com.incomee.incomee.data.model.OperationTypeFilterEntity

private const val SHARED_PREFS_NAME = "shared_preferences"

class OperationTypeFilterStorage(context: Context) : FilterStorage {

    private val sp = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(filters: List<OperationTypeFilterEntity>) {
        filters.stream().forEach { sp.edit().putString(it.type, it.name).apply() }
    }

    override fun remove(filters: List<OperationTypeFilterEntity>) {
        filters.stream().forEach { sp.edit().remove(it.type).apply() }
    }

    override fun get(): List<OperationTypeFilterEntity> {
        val activeFilters = ArrayList<OperationTypeFilterEntity>()
        for(filterType in OPERATION_TYPES) {
            val filterName = sp.getString(filterType, "")
            if(!filterName.isNullOrEmpty())
                activeFilters.add(OperationTypeFilterEntity(name = filterName, type = filterType))
        }
        return activeFilters
    }

}