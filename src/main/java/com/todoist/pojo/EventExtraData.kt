package com.todoist.pojo

open class EventExtraData(
    open var content: String?,
    open var lastContent: String?,
    open var description: String?,
    open var lastDescription: String?,
    open var dueDate: Long?,
    open var lastDueDate: Long?,
    open var responsibleUid: Long?,
    open var lastResponsibleUid: Long?,
    open var name: String?,
    open var lastName: String?,
    open var parentProjectName: String?,
    open var parentProjectColor: Int?,
    open var parentItemContent: String?,
    open var noteCount: Int?,
    open var subTasksReset: Int?,
)
