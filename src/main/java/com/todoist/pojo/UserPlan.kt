package com.todoist.pojo

interface UserPlan {
    val planName: String
    val maxProjects: Int
    val maxTasks: Int
    val maxSections: Int
    val maxFilters: Int
    val maxLabels: Int
    val maxCollaborators: Int
    val maxRemindersTime: Int
    val maxRemindersLocation: Int
    val uploadLimitMb: Int
    val weeklyTrends: Boolean
    val customizationColor: Boolean
    val automaticBackups: Boolean
    val emailForwarding: Boolean
    val calendarFeeds: Boolean
    val templates: Boolean
    val activityLog: Boolean
    val activityLogLimit: Int
    val comments: Boolean
    val reminders: Boolean
    val labels: Boolean
    val filters: Boolean
    val completedTasks: Boolean
    val uploads: Boolean
}
