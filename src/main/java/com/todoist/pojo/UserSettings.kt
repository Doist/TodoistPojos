package com.todoist.pojo

open class UserSettings<Q : QuickAddCustomization<out Feature>>(
    open val reminderPush: Boolean,
    open val reminderDesktop: Boolean,
    open val reminderEmail: Boolean,
    open val completedSoundDesktop: Boolean,
    open val completedSoundMobile: Boolean,
    open val quickAddCustomization: Q?,
)
