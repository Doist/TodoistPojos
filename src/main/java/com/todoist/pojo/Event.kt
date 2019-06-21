package com.todoist.pojo

open class Event<E: EventExtraData>(
        open var parentProjectId: Long?, 
        open var parentItemId: Long?, 
        open var eventType: String?, 
        open var objectType: String?,
        open var objectId: Long?,
        open var initiatorId: Long?, 
        open var eventDate: Long?, 
        open var eventExtraData: E?,
        open var id: Long)
