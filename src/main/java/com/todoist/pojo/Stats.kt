package com.todoist.pojo

open class Stats<SD : StatsDay, SW : StatsWeek>(
        open var completedCount: Int,
        daysItems: List<SD>,
        weekItems: List<SW>
) {
    open var daysItems: List<SD> = Utils.unmodifiableList(daysItems)
        set(value) {
            field = Utils.unmodifiableList(value)
        }
    open var weekItems: List<SW> = Utils.unmodifiableList(weekItems)
        set(value) {
            field = Utils.unmodifiableList(value)
        }
}
