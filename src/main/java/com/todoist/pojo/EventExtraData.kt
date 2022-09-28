package com.todoist.pojo

open class EventExtraData(
    open var content: String?,
    open var lastContent: String?,
    open var description: String?,
    open var lastDescription: String?,
    open var dueDate: Long?,
    open var lastDueDate: Long?,
    open var responsibleUid: String?,
    open var lastResponsibleUid: String?,
    open var name: String?,
    open var lastName: String?,
    open var parentProjectName: String?,
    open var parentProjectColor: String?,
    open var parentItemContent: String?,
    open var noteCount: Int?,
    open var subTasksReset: Int?,
)
