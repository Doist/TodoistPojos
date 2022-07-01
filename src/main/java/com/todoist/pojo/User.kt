package com.todoist.pojo

open class User<T : TzInfo, F : Features>(
    id: Long,
    email: String,
    fullName: String,
    imageId: String?,
    open var apiToken: String?,
    open var tzInfo: T?,
    open var isPremium: Boolean,
    open var premiumUntil: Long?,
    open var freeTrialExpires: Long?,
    open var startPage: String?,
    open var startDay: Int?,
    open var weekendStartDay: Int?,
    open var nextWeek: Int?,
    open var teamInbox: Long?,
    open var shareLimit: Int?,
    open var karma: Long?,
    open var karmaTrend: String?,
    open var isKarmaDisabled: Boolean,
    open var isKarmaVacation: Boolean,
    open var autoReminder: Int?,
    open var theme: Int?,
    open var features: F?,
    open var businessAccountId: Long?,
    open var dailyGoal: Int?,
    open var weeklyGoal: Int?,
    open var daysOff: IntArray?,
    open var uniquePrefix: Long?,
    open var hasPassword: Boolean,
    open var verificationStatus: VerificationStatus,
    open var multiFactorAuthEnabled: Boolean,
) : Person(id, email, fullName, imageId, false) {
    enum class VerificationStatus(private val key: String) {
        VERIFIED("verified"),
        VERIFIED_BY_THIRD_PARTY("verified_by_third_party"),
        UNVERIFIED("unverified"),
        LEGACY("legacy"),
        BLOCKED("blocked");

        override fun toString() = key

        companion object {
            fun get(statusKey: String): VerificationStatus = values().first { it.key == statusKey }
        }
    }
}
