package com.todoist.pojo

open class ViewOption(
    id: Long,
    open var viewType: Type?,
    open var objectId: Long?,
    open var sortedBy: Sort?,
    open var sortOrder: SortOrder?,
    open var groupedBy: Group?,
    open var filteredBy: String?,
    isDeleted: Boolean
) : TodoistObject(id, isDeleted) {
    enum class Type(private val key: String) {
        TODAY("TODAY"),
        PROJECT("PROJECT"),
        LABEL("LABEL"),
        FILTER("FILTER");

        override fun toString() = key

        companion object {
            fun get(typeKey: String?): Type? = values().find { it.key == typeKey }
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
}
