package com.incomee.incomee.data.repository.storage

import android.content.Context
import com.incomee.incomee.data.model.OperationTypeFilterEntity
import com.incomee.incomee.data.model.OperationTypeFilterEntity.OperationType

private const val SHARED_PREFS_NAME = "shared_preferences"

class OperationTypeFilterStorage(context: Context) : FilterStorage {

    private val sp = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun toggle(filter: OperationTypeFilterEntity) {
        if(sp.getString(filter.type.value, "").isNullOrEmpty())
            sp.edit().putString(filter.type.value, filter.name).apply()
        else sp.edit().remove(filter.type.value).apply()
    }

    override fun clear() {
        for(filterType in OperationType.values()) {
            val filterName = sp.getString(filterType.value, "")
            if(!filterName.isNullOrEmpty())
                sp.edit().remove(filterType.value).apply()
        }
    }

    override fun get(): List<OperationTypeFilterEntity> {
        val activeFilters = ArrayList<OperationTypeFilterEntity>()
        for(filterType in OperationType.values()) {
            val filterName = sp.getString(filterType.value, "")
            if(!filterName.isNullOrEmpty())
                activeFilters.add(OperationTypeFilterEntity(name = filterName, type = filterType))
        }
        return activeFilters
    }

}