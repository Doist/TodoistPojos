package com.todoist.pojo

open class Label @JvmOverloads constructor(
        id: Long,
        name: String,
        open var color: Int = Colors.DEFAULT_COLOR_ID,
        open var itemOrder: Int,
        open var isFavorite: Boolean,
        isDeleted: Boolean = false
) : TodoistObject(id, isDeleted) {
    open var name: String = sanitizeName(name)
        set(value) {
            field = sanitizeName(value)
        }

    val colorInt get() = Colors.getColor(color)

    companion object {
        const val MAX_COUNT = 500

        @JvmStatic
        fun sanitizeName(name: String): String =
                Sanitizers.LABEL_NAME_INVALID_PATTERN.matcher(name.trim()).replaceAll(Sanitizers.REPLACEMENT)

    }
}
