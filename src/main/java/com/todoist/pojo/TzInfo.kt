package com.todoist.pojo

open class TzInfo(
        open var text: String?,
        open var timezone: String,
        open var minutes: Int,
        open var hours: Int,
        open var isDst: Boolean,
        var gmtString: String?)
