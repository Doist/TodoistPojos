package com.todoist.pojo

open class Item<D : Due> @JvmOverloads constructor(
        id: Long,
        open var content: String,
        open var projectId: Long,
        priority: Int,
        due: D?,
        open var sectionId: Long?,
        open var parentId: Long?,
        open var childOrder: Int = 0,
        open var dayOrder: Int = -1,
        open var isChecked: Boolean = false,
        open var isCollapsed: Boolean = false,
        open var assignedByUid: Long?,
        open var responsibleUid: Long?,
        labels: Collection<Long>? = null,
        open var isInHistory: Boolean = false,
        open var dateAdded: Long,
        open var dateCompleted: Long? = null,
        deleted: Boolean = false
) : TodoistObject(id, deleted) {
    var labels: Set<Long>? = labels?.toSet().orEmpty()
        private set

    open var priority: Int = priority
        /**
         * Returns the priority within the bounds defined by [.MIN_PRIORITY] and [.MAX_PRIORITY].
         */
        get() = field.coerceIn(MIN_PRIORITY, MAX_PRIORITY)
        set(value) {
            if (field != value) {
                field = value
                dayOrder = -1
            }
        }

    open var due: D? = due
        /**
         * Sets the due date, with the side effect of resetting the day order to its default value of -1.
         */
        set(value) {
            if (field != value) {
                field = value
                dayOrder = -1
            }
        }

    open fun setLabels(labels: Collection<Long>?) {
        this.labels = labels?.toSet().orEmpty()
    }

    companion object {
        const val MAX_DEPTH = 4
        const val MIN_PRIORITY = 1
        const val MAX_PRIORITY = 4
    }
}
