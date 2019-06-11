package com.todoist.pojo

open class Stats<D : StatsDay, W : StatsWeek>(
        open var completedCount: Int,
        open var daysItems: List<D>,
        open var weekItems: List<W>)
