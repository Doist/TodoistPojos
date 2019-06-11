package com.todoist.pojo

open class Reminder<D: Due> @JvmOverloads constructor(
        id: Long,
        open var type: String?,
        /** Exclusive to reminders of type [.TYPE_ABSOLUTE].  */
        open var due: D?,
        /** Exclusive to reminders of type [.TYPE_RELATIVE].  */
        open var minuteOffset: Int?,
        /** Exclusive to reminders of type [.TYPE_LOCATION].  */
        open var name: String?,
        /** Exclusive to reminders of type [.TYPE_LOCATION].  */
        open var locLat: Double?,
        /** Exclusive to reminders of type [.TYPE_LOCATION].  */
        open var locLong: Double?,
        /** Exclusive to reminders of type [.TYPE_LOCATION].  */
        open var radius: Int?,
        /** Exclusive to reminders of type [.TYPE_LOCATION].  */
        open var locTrigger: String?,
        open var notifyUid: Long?,
        open var itemId: Long,
        isDeleted: Boolean = false
) : TodoistObject(id, isDeleted) {
    open val isAbsolute get() = TYPE_ABSOLUTE == type
    open val isRelative get() = TYPE_RELATIVE == type
    open val isLocation get() = TYPE_LOCATION == type

    companion object {
        const val TYPE_ABSOLUTE = "absolute"
        const val TYPE_RELATIVE = "relative"
        const val TYPE_LOCATION = "location"

        const val DEFAULT_MINUTE_OFFSET = 30

        const val LOC_TRIGGER_ON_ENTER = "on_enter"
        const val LOC_TRIGGER_ON_LEAVE = "on_leave"

        const val MAX_COUNT = 700
    }
}
