package com.todoist.pojo

open class Label @JvmOverloads constructor(
    id: String,
    open var name: String,
    open var color: String = Colors.DEFAULT_COLOR_NAME,
    open var itemOrder: Int,
    open var isFavorite: Boolean,
    isDeleted: Boolean = false
) : Model(id, isDeleted) {
    companion object {
        @JvmStatic
        fun sanitizeName(name: String): String =
            Sanitizers.LABEL_NAME_INVALID_PATTERN.matcher(name.trim())
                .replaceAll(Sanitizers.REPLACEMENT)
    }
}
