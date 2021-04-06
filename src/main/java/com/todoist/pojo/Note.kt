package com.todoist.pojo

open class Note<F : FileAttachment> @JvmOverloads constructor(
    id: Long,
    open var content: String?,
    open var posted: Long = System.currentTimeMillis(),
    open var postedUid: Long,
    open var uidsToNotify: Set<Long> = emptySet(),
    open var fileAttachment: F? = null,
    open var reactions: Map<String, LongArray> = emptyMap(),
    open var projectId: Long?,
    open var itemId: Long?,
    open var isArchived: Boolean = false,
    isDeleted: Boolean = false
) : Model(id, isDeleted)
