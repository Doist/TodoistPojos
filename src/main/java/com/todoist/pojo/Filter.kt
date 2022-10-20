package com.todoist.pojo

open class Filter @JvmOverloads constructor(
    id: String,
    open var name: String,
    open var color: String = Colors.DEFAULT_COLOR_NAME,
    open var query: String,
    open var itemOrder: Int,
    open var isFavorite: Boolean,
    isDeleted: Boolean = false
) : Model(id, isDeleted) {
    companion object {
        @JvmStatic
        fun sanitizeName(name: String): String = name.trim()
    }
}
