package com.todoist.pojo

open class CompletedInfo(
        open val projectId: Long?,
        open val sectionId: Long?,
        open val itemId: Long?,
        open val completedItems: Int,
        open val archivedSections: Int?)
