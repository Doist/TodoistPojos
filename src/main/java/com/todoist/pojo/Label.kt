package com.todoist.pojo

open class Label @JvmOverloads constructor(
    id: Long,
    open var name: String,
    open var color: Int = Colors.DEFAULT_COLOR_ID,
    open var itemOrder: Int,
    open var isFavorite: Boolean,
    isDeleted: Boolean = false
) : Model(id, isDeleted) {
    val colorInt get() = Colors.getColor(color)

    companion object {
        @JvmStatic
        fun sanitizeName(name: String): String =
            Sanitizers.LABEL_NAME_INVALID_PATTERN.matcher(name.trim())
                .replaceAll(Sanitizers.REPLACEMENT)
    }
}
