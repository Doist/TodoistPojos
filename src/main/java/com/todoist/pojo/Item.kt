package com.todoist.pojo

open class Item<D : Due> @JvmOverloads constructor(
        id: Long,
        open var content: String,
        open var projectId: Long,
        priority: Int,
        due: D?,
        open var sectionId: Long?,
        open var parentId: Long?,
        open var childOrder: Int = MIN_CHILD_ORDER,
        open var dayOrder: Int = -1,
        open var isChecked: Boolean = false,
        open var isCollapsed: Boolean = false,
        open var assignedByUid: Long?,
        open var responsibleUid: Long?,
        labels: Collection<String>? = null,
        open var isInHistory: Boolean = false,
        open var dateAdded: Long,
        open var dateCompleted: Long? = null,
        isDeleted: Boolean = false
) : TodoistObject(id, isDeleted) {
    open var labels: Set<String> = labels?.toSet().orEmpty()
        set(value) {
            field = value.toSet()
        }

    /**
     * Returns the priority within the bounds defined by [.MIN_PRIORITY] and [.MAX_PRIORITY].
     */
    open var priority: Int = priority
        get() = field.coerceIn(MIN_PRIORITY, MAX_PRIORITY)
        set(value) {
            if (field != value) {
                field = value
                dayOrder = -1
            }
        }

    /**
     * Sets the due date, with the side effect of resetting the day order to its default value of -1.
     */
    open var due: D? = due
        set(value) {
            if (field != value) {
                field = value
                dayOrder = -1
            }
        }

    open fun setLabels(labels: Collection<String>?) {
        this.labels = labels?.toSet().orEmpty()
    }

    companion object {
        const val MIN_CHILD_ORDER = 1
        const val MIN_DEPTH = 0
        const val MAX_DEPTH = 4
        const val MIN_PRIORITY = 1
        const val MAX_PRIORITY = 4
        const val MAX_LABEL_COUNT = 100
    }
}
