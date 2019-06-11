package com.todoist.pojo

open class LiveNotification<C : Collaborator>(
        id: Long,
        var notificationType: String,
        open var created: Long,
        open var isUnread: Boolean,
        // Optional fields, not set in all types.
        open var fromUid: Long?,
        open var projectId: Long?,
        open var projectName: String?,
        open var invitationId: Long?,
        open var invitationSecret: String?,
        open var state: String?,
        open var itemId: Long?,
        open var itemContent: String?,
        open var responsibleUid: Long?,
        open var noteId: Long?,
        open var noteContent: String?,
        open var removedUid: Long?,
        open var fromUser: C?,
        open var accountName: String?,
        // Optional fields used in Karma notifications (which are set depends on the karma level).
        open var karmaLevel: Int?,
        open var completedTasks: Int?,
        open var completedInDays: Int?,
        open var completedLastMonth: Int?,
        open var topProcent: Double?,
        open var dateReached: Long?,
        open var promoImg: String?,
        isDeleted: Boolean
) : TodoistObject(id, isDeleted) {
    open val isInvitation get() =
        notificationType == TYPE_SHARE_INVITATION_SENT || notificationType == TYPE_BIZ_INVITATION_CREATED

    open val isStatePending get() = state != STATE_ACCEPTED && state!= STATE_REJECTED

    companion object {
        const val TYPE_SHARE_INVITATION_SENT = "share_invitation_sent"
        const val TYPE_SHARE_INVITATION_ACCEPTED = "share_invitation_accepted"
        const val TYPE_SHARE_INVITATION_REJECTED = "share_invitation_rejected"
        const val TYPE_USER_LEFT_PROJECT = "user_left_project"
        const val TYPE_USER_REMOVED_FROM_PROJECT = "user_removed_from_project"
        const val TYPE_NOTE_ADDED = "note_added"
        const val TYPE_ITEM_ASSIGNED = "item_assigned"
        const val TYPE_ITEM_COMPLETED = "item_completed"
        const val TYPE_ITEM_UNCOMPLETED = "item_uncompleted"
        const val TYPE_KARMA_LEVEL = "karma_level"

        const val TYPE_BIZ_POLICY_DISALLOWED_INVITATION = "biz_policy_disallowed_invitation"
        const val TYPE_BIZ_POLICY_REJECTED_INVITATION = "biz_policy_rejected_invitation"
        const val TYPE_BIZ_TRIAL_WILL_END = "biz_trial_will_end"
        const val TYPE_BIZ_PAYMENT_FAILED = "biz_payment_failed"
        const val TYPE_BIZ_ACCOUNT_DISABLED = "biz_account_disabled"
        const val TYPE_BIZ_INVITATION_CREATED = "biz_invitation_created"
        const val TYPE_BIZ_INVITATION_ACCEPTED = "biz_invitation_accepted"
        const val TYPE_BIZ_INVITATION_REJECTED = "biz_invitation_rejected"

        const val STATE_INVITED = "invited"
        const val STATE_ACCEPTED = "accepted"
        const val STATE_REJECTED = "rejected"
    }
}
