package com.todoist.pojo

open class Note<F : FileAttachment> @JvmOverloads constructor(
    id: String,
    open var v2Id: String? = null,
    open var content: String?,
    open var postedAt: Long = System.currentTimeMillis(),
    open var postedUid: String,
    open var uidsToNotify: Set<String> = emptySet(),
    open var fileAttachment: F? = null,
    open var reactions: Map<String, Array<String>> = emptyMap(),
    open var projectId: String?,
    open var itemId: String?,
    open var isArchived: Boolean = false,
    isDeleted: Boolean = false
) : Model(id, isDeleted)
