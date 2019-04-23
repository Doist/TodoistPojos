package com.todoist.pojo

open class Features(
        open var text: String?,
        open var restriction: Int,
        open var isDateistInlineDisabled: Boolean,
        open var dateistLang: String?,
        open var goldTheme: Boolean,
        open var isAutoAcceptInvitesDisabled: Boolean
)
