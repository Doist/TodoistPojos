package com.todoist.pojo

open class Event<E : EventExtraData>(
    open var parentProjectId: String?,
    open var parentItemId: String?,
    open var eventType: String?,
    open var objectType: String?,
    open var objectId: String?,
    open var initiatorId: String?,
    open var eventDate: Long?,
    open var eventExtraData: E?,
    open var id: String
)
