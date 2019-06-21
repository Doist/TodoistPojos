package com.todoist.pojo

open class TodoistObject(open var id: Long, open var isDeleted: Boolean) {
    open fun hasTempId() = id < 0

    override fun equals(other: Any?) = when {
        this === other -> true
        other == null || javaClass != other.javaClass -> false
        else -> id == (other as TodoistObject).id
    }

    override fun hashCode() = (id xor id.ushr(32)).toInt()
}
