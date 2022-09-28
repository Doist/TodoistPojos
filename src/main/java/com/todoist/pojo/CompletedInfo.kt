package com.todoist.pojo

open class CompletedInfo(
    open val projectId: String?,
    open val sectionId: String?,
    open val itemId: String?,
    open val completedItems: Int,
    open val archivedSections: Int?
)
