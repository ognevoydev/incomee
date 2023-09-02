package com.incomee.incomee.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.incomee.incomee.data.dao.OperationDao
import com.incomee.incomee.data.model.OperationEntity
import com.incomee.incomee.data.model.converter.DateConverter

@Database(
    entities = [OperationEntity::class],
    version = 1
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun operationDao(): OperationDao
}