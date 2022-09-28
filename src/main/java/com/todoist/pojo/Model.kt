package com.todoist.pojo

open class Model(open var id: String, open var isDeleted: Boolean) {
    open fun hasTempId() = id.isNotEmpty() && id[0] == '-'

    override fun equals(other: Any?) = when {
        this === other -> true
        other == null || javaClass != other.javaClass -> false
        else -> id == (other as Model).id
    }

    override fun hashCode() = id.hashCode()
}
