package com.todoist.pojo

open class Stats<SD : StatsDay, SW : StatsWeek>(
        open var completedCount: Int,
        open var daysItems: List<SD>,
        open var weekItems: List<SW>)
