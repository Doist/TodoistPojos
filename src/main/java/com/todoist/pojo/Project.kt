package com.todoist.pojo

open class Project @JvmOverloads constructor(
    id: String,
    open var v2Id: String? = null,
    open var name: String,
    open var workspaceId: String? = null,
    open var description: String? = null,
    open var isInviteOnly: Boolean = false,
    open var status: Status = Status.Planned,
    open var color: String = Colors.DEFAULT_COLOR_NAME,
    open var viewStyle: String = VIEW_STYLE_DEFAULT,
    open var parentId: String?,
    open var v2ParentId: String?,
    open var childOrder: Int,
    open var isCollapsed: Boolean = false,
    open var isInbox: Boolean = false,
    open var isTeamInbox: Boolean = false,
    open var isShared: Boolean = false,
    open var isFavorite: Boolean,
    open var isArchived: Boolean = false,
    isDeleted: Boolean = false
) : Model(id, isDeleted) {
    sealed class Status(protected open val key: String) {
        object Planned : Status("PLANNED")

        object InProgress : Status("IN_PROGRESS")

        object Paused : Status("PAUSED")

        object Completed : Status("COMPLETED")

        object Canceled : Status("CANCELED")

        data class Unknown(override val key: String) : Status(key)

        object Invalid : Status("INVALID")

        override fun toString() = key

        companion object {
            fun get(typeKey: String?): Status {
                val upperCasedKey = typeKey?.uppercase()
                return when {
                    upperCasedKey.isNullOrEmpty() -> Invalid
                    upperCasedKey == Planned.key -> Planned
                    upperCasedKey == InProgress.key -> InProgress
                    upperCasedKey == Paused.key -> Paused
                    upperCasedKey == Completed.key -> Completed
                    upperCasedKey == Canceled.key -> Canceled
                    else -> Unknown(typeKey)
                }
            }
        }
    }

    companion object {
        const val VIEW_STYLE_LIST = "list"
        const val VIEW_STYLE_BOARD = "board"
        const val VIEW_STYLE_DEFAULT = VIEW_STYLE_LIST

        const val DEFAULT_CHILD_ORDER = 1
        const val MIN_DEPTH = 0
        const val MAX_DEPTH = 3

        @JvmStatic
        fun sanitizeName(name: String): String =
            Sanitizers.PROJECT_NAME_INVALID_PATTERN.matcher(name.trim())
                .replaceAll(Sanitizers.REPLACEMENT)
    }
}
