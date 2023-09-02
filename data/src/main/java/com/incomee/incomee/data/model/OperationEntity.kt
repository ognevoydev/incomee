package com.incomee.incomee.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.incomee.incomee.data.model.converter.DateConverter
import java.util.*

@Entity(tableName = "operations")
@TypeConverters(DateConverter::class)
class OperationEntity(
    @PrimaryKey(autoGenerate = true) var id: Long,
    @ColumnInfo(name = "amount") var amount: Long,
    @ColumnInfo(name = "category") var category: String,
    @ColumnInfo(name = "account") var account: String,
    @ColumnInfo(name = "date") var date: Long,
    @ColumnInfo(name = "comment") var comment: String
)