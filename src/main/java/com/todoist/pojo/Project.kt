package com.todoist.pojo

open class Project @JvmOverloads constructor(
        id: Long,
        name: String,
        open var color: Int = Colors.DEFAULT_COLOR_ID,
        open var parentId: Long?,
        open var childOrder: Int,
        open var isCollapsed: Boolean = false,
        open var isInbox: Boolean = false,
        open var isTeamInbox: Boolean = false,
        open var isShared: Boolean = false,
        open var isFavorite: Boolean,
        open var isArchived: Boolean = false,
        deleted: Boolean = false
) : TodoistObject(id, deleted) {
    open var name: String = sanitizeName(name)!!
        set(value) {
            field = sanitizeName(value)!!
        }

    open val colorInt: Int
        get() = Colors.getColor(color)

    companion object {
        const val MAX_DEPTH = 3

        const val MAX_COUNT_FREE = 80
        const val MAX_COUNT_PREMIUM = 300
        const val MAX_COUNT_BUSINESS = 500
        const val MAX_SECTION_COUNT = 10
        const val MAX_ITEM_COUNT_FREE = 150
        const val MAX_ITEM_COUNT_PREMIUM = 300
        const val MAX_COLLABORATOR_COUNT_FREE = 5
        const val MAX_COLLABORATORS_COUNT_PREMIUM = 25
        const val MAX_COLLABORATORS_COUNT_BUSINESS = 50

        @JvmStatic
        fun sanitizeName(name: String?): String? =
                Sanitizers.PROJECT_NAME_INVALID_PATTERN.matcher(name?.trim { it <= ' ' })
                                                       .replaceAll(Sanitizers.REPLACEMENT)
    }
}