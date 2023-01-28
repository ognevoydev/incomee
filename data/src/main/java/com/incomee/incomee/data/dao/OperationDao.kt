package com.incomee.incomee.data.dao

import androidx.room.*
import com.incomee.incomee.data.model.OperationEntity

@Dao
interface OperationDao {

    @Query("SELECT * FROM operations")
    fun getAll(): List<OperationEntity>

    @Query("SELECT * FROM operations WHERE comment LIKE :comment")
    fun findByComment(comment: String): OperationEntity

    @Insert
    fun insert(operation: OperationEntity)

    @Delete
    fun delete(operation: OperationEntity)

    @Update
    fun update(operation: OperationEntity)
}