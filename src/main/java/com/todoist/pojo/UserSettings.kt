package com.todoist.pojo

open class UserSettings<
    Q : QuickAddCustomization<out Feature>,
    N : NavigationCustomization<out Feature>,
    P : HabitPushNotifications<out NotificationFeature>,
    >(
    open val reminderPush: Boolean,
    open val reminderDesktop: Boolean,
    open val reminderEmail: Boolean,
    open val completedSoundDesktop: Boolean,
    open val completedSoundMobile: Boolean,
    open val quickAddCustomization: Q?,
    open val navigationCustomization: N?,
    open val habitPushNotifications: P?,
)
