package com.todoist.pojo

open class Item<D : Due> @JvmOverloads constructor(
    id: String,
    open var v2Id: String? = null,
    open var content: String,
    open var description: String? = null,
    open var projectId: String,
    open var v2ProjectId: String? = null,
    priority: Int,
    due: D?,
    open var sectionId: String?,
    open var v2SectionId: String? = null,
    open var parentId: String?,
    open var v2ParentId: String? = null,
    open var childOrder: Int = DEFAULT_CHILD_ORDER,
    open var dayOrder: Int = DEFAULT_DAY_ORDER,
    open var isChecked: Boolean = false,
    open var isCollapsed: Boolean = false,
    open var assignedByUid: String?,
    open var responsibleUid: String?,
    open var labels: Set<String> = emptySet(),
    open var addedAt: Long,
    open var addedByUid: String?,
    open var completedAt: Long? = null,
    isDeleted: Boolean = false
) : Model(id, isDeleted) {

    /**
     * Returns the priority within the bounds defined by [MIN_PRIORITY] and [MAX_PRIORITY].
     */
    open var priority: Int = priority
        get() = field.coerceIn(MIN_PRIORITY, MAX_PRIORITY)
        set(value) {
            if (field != value) {
                field = value
                dayOrder = DEFAULT_DAY_ORDER
            }
        }

    /**
     * Sets the due date, with the side effect of resetting the day order to its default value of
     * [DEFAULT_DAY_ORDER].
     */
    open var due: D? = due
        set(value) {
            if (field != value) {
                field = value
                dayOrder = DEFAULT_DAY_ORDER
            }
        }

    companion object {
        const val DEFAULT_CHILD_ORDER = 1
        const val MIN_DEPTH = 0
        const val MAX_DEPTH = 4
        const val MIN_PRIORITY = 1
        const val MAX_PRIORITY = 4
        const val DEFAULT_DAY_ORDER = -1
        const val MAX_LABEL_COUNT = 100
        const val MAX_CONTENT_CHAR_COUNT = 500
        const val MAX_DESCRIPTION_CHAR_COUNT = 16384
    }
}
