package com.todoist.pojo

import java.util.Locale

open class ViewOption(
    id: Long,
    open var viewType: Type,
    open var objectId: Long?,
    open var sortedBy: Sort?,
    open var sortOrder: SortOrder?,
    open var groupedBy: Group?,
    open var filteredBy: String?,
    open var viewMode: ViewMode,
    isDeleted: Boolean
) : Model(id, isDeleted) {
    sealed class Type(protected open val key: String) {
        object Today : Type("TODAY")

        object Project : Type("PROJECT")

        object Label : Type("LABEL")

        object Filter : Type("FILTER")

        data class Unknown(override val key: String) : Type(key)

        object Invalid : Type("INVALID")

        override fun toString() = key

        companion object {
            fun get(typeKey: String?) = when {
                typeKey.isNullOrEmpty() -> Invalid
                typeKey == Today.key -> Today
                typeKey == Project.key -> Project
                typeKey == Label.key -> Label
                typeKey == Filter.key -> Filter
                else -> Unknown(typeKey)
            }
        }
    }

    enum class Sort(private val key: String) {
        ALPHABETICALLY("ALPHABETICALLY"),
        ASSIGNEE("ASSIGNEE"),
        ADDED_DATE("ADDED_DATE"),
        DUE_DATE("DUE_DATE"),
        PRIORITY("PRIORITY"),
        PROJECT("PROJECT");

        override fun toString() = key

        companion object {
            fun get(sortKey: String?): Sort? = values().find { it.key == sortKey }
        }
    }

    enum class SortOrder(private val key: String) {
        ASC("ASC"),
        DESC("DESC");

        override fun toString() = key

        companion object {
            fun get(sortKey: String?): SortOrder? = values().find { it.key == sortKey }
        }
    }

    enum class Group(private val key: String) {
        ASSIGNEE("ASSIGNEE"),
        ADDED_DATE("ADDED_DATE"),
        DUE_DATE("DUE_DATE"),
        LABEL("LABEL"),
        PRIORITY("PRIORITY"),
        PROJECT("PROJECT");

        override fun toString() = key

        companion object {
            fun get(groupKey: String?): Group? = values().find { it.key == groupKey }
        }
    }

    enum class ViewMode(private val key: String) {
        LIST("LIST"),
        BOARD("BOARD");

        override fun toString() = key

        companion object {
            fun get(viewKey: String?): ViewMode =
                values().find { it.key == viewKey?.uppercase(Locale.getDefault()) } ?: LIST
        }
    }
}
