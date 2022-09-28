package com.todoist.pojo

open class Model(open var id: String, open var isDeleted: Boolean) {
    override fun equals(other: Any?) = when {
        this === other -> true
        other == null || javaClass != other.javaClass -> false
        else -> id == (other as Model).id
    }

    override fun hashCode() = id.hashCode()
}
