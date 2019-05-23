package com.todoist.pojo

open class Note<FA : FileAttachment> @JvmOverloads constructor(
        id: Long,
        open var content: String?,
        open var posted: Long = System.currentTimeMillis(),
        open var postedUid: Long,
        uidsToNotify: Collection<Long>?,
        open var fileAttachment: FA? = null,
        open var reactions: Map<String, LongArray> = emptyMap(),
        open var projectId: Long?,
        open var itemId: Long?,
        open var isArchived: Boolean = false,
        deleted: Boolean = false
) : TodoistObject(id, deleted) {
    /**
     * @return Unmodifiable set of label ids.
     */
    var uidsToNotify: Set<Long>? = uidsToNotify.orEmpty().toSet()
        private set

    /**
     * Copies the user ids to notify into an unmodifiable set.
     */
    fun setUidsToNotify(uidsToNotify: Collection<Long>) {
        this.uidsToNotify = uidsToNotify.toSet()
    }
}
