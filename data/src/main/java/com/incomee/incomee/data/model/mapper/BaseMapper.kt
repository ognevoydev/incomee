package com.incomee.incomee.data.model.mapper

interface BaseMapper<Domain : Any, Entity : Any> {
    fun toEntity(value: Domain): Entity
    fun toDomain(value: Entity): Domain
}