package com.todoist.pojo

open class Note<FA : FileAttachment> @JvmOverloads constructor(
        id: Long,
        open var content: String?,
        open var posted: Long = System.currentTimeMillis(),
        open var postedUid: Long,
        uidsToNotify: Collection<Long>?,
        open var fileAttachment: FA? = null,
        reactions: Map<String, LongArray>? = null,
        open var projectId: Long?,
        open var itemId: Long?,
        open var isArchived: Boolean = false,
        deleted: Boolean = false
) : TodoistObject(id, deleted) {
    /**
     * @return Unmodifiable set of label ids.
     */
    var uidsToNotify: Set<Long>? = Utils.unmodifiableSet(uidsToNotify)
        private set

    open var reactions: Map<String, LongArray>? = Utils.unmodifiableMap(reactions)
        set(value) {
            field = Utils.unmodifiableMap(value)
        }

    /**
     * Copies the user ids to notify into an unmodifiable set.
     */
    fun setUidsToNotify(uidsToNotify: Collection<Long>) {
        this.uidsToNotify = Utils.unmodifiableSet(uidsToNotify)
    }
}
