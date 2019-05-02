package com.todoist.pojo

open class Due(
        open val date: String,
        open val timezone: String?,
        open val string: String,
        open val lang: String,
        open val isRecurring: Boolean
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }

        val d = other as Due?
        return date == d?.date && timezone == d.timezone && string == d.string && lang == d.lang
                && isRecurring == d.isRecurring
    }

    override fun hashCode(): Int {
        var hash = 23
        hash = 31 * hash + (date.hashCode())
        hash = 31 * hash + (timezone?.hashCode() ?: 0)
        hash = 31 * hash + (string.hashCode())
        hash = 31 * hash + (lang.hashCode())
        hash = 31 * hash + if (isRecurring) 1231 else 1237
        return hash
    }
}
