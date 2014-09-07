package com.todoist.model;

public class BaseLiveNotification extends TodoistObject {
    public static final String TYPE_SHARE_INVITATION_SENT = "share_invitation_sent";
    public static final String TYPE_SHARE_INVITATION_ACCEPTED = "share_invitation_accepted";
    public static final String TYPE_SHARE_INVITATION_REJECTED = "share_invitation_rejected";
    public static final String TYPE_USER_LEFT_PROJECT = "user_left_project";
    public static final String TYPE_USER_REMOVED_FROM_PROJECT = "user_removed_from_project";
    public static final String TYPE_NOTE_ADDED = "note_added";
    public static final String TYPE_ITEM_ASSIGNED = "item_assigned";
    public static final String TYPE_ITEM_COMPLETED = "item_completed";
    public static final String TYPE_ITEM_UNCOMPLETED = "item_uncompleted";

    public static final String TYPE_BIZ_POLICY_DISALLOWED_INVITATION = "biz_policy_disallowed_invitation";
    public static final String TYPE_BIZ_POLICY_REJECTED_INVITATION = "biz_policy_rejected_invitation";
    public static final String TYPE_BIZ_TRIAL_WILL_END = "biz_trial_will_end";
    public static final String TYPE_BIZ_PAYMENT_FAILED = "biz_payment_failed";
    public static final String TYPE_BIZ_ACCOUNT_DISABLED = "biz_account_disabled";
    public static final String TYPE_BIZ_INVITATION_CREATED = "biz_invitation_created";
    public static final String TYPE_BIZ_INVITATION_ACCEPTED = "biz_invitation_accepted";
    public static final String TYPE_BIZ_INVITATION_REJECTED = "biz_invitation_rejected";

    public static final String STATE_ACCEPTED = "accepted";
    public static final String STATE_REJECTED = "rejected";

    private String notificationKey;
    private String notificationType;
    private long seqNo;
    private long created;

    // Optional fields, not set in all types.
    private Long fromUid;
    private Long projectId;
    private String projectName;
    private Long invitationId;
    private String invitationSecret;
    private String state;
    private Long itemId;
    private String itemContent;
    private Long responsibleUid;
    private Long noteId;
    private String noteContent;
    private Long removedUid;
    private BaseCollaborator fromUser;
    private String accountName;

    public BaseLiveNotification(String notificationKey, String notificationType, long seqNo, long created,
                                Long fromUid, Long projectId, String projectName, Long invitationId,
                                String invitationSecret, String state, Long itemId, String itemContent,
                                Long responsibleUid, Long noteId, String noteContent, Long removedUid,
                                BaseCollaborator fromUser, String accountName, boolean deleted) {
        super(deleted);
        this.notificationKey = notificationKey;
        this.notificationType = notificationType;
        this.seqNo = seqNo;
        this.created = created;
        this.fromUid = fromUid;
        this.projectId = projectId;
        this.projectName = projectName;
        this.invitationId = invitationId;
        this.invitationSecret = invitationSecret;
        this.state = state;
        this.itemId = itemId;
        this.itemContent = itemContent;
        this.responsibleUid = responsibleUid;
        this.noteId = noteId;
        this.noteContent = noteContent;
        this.removedUid = removedUid;
        this.fromUser = fromUser;
        this.accountName = accountName;
    }

    public String getNotificationKey() {
        return notificationKey;
    }

    public boolean isInvitation() {
        return Utils.equals(notificationType, TYPE_SHARE_INVITATION_SENT) ||
               Utils.equals(notificationType, TYPE_BIZ_INVITATION_CREATED);
    }

    public void setNotificationKey(String notificationKey) {
        this.notificationKey = notificationKey;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public long getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(long seqNo) {
        this.seqNo = seqNo;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public Long getFromUid() {
        return fromUid;
    }

    public void setFromUid(Long fromUid) {
        this.fromUid = fromUid;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Long invitationId) {
        this.invitationId = invitationId;
    }

    public String getInvitationSecret() {
        return invitationSecret;
    }

    public void setInvitationSecret(String invitationSecret) {
        this.invitationSecret = invitationSecret;
    }

    public String getState() {
        return state;
    }

    public boolean isStatePending() {
        return !Utils.equals(state, STATE_ACCEPTED) && !Utils.equals(state, STATE_REJECTED);
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    public Long getResponsibleUid() {
        return responsibleUid;
    }

    public void setResponsibleUid(Long responsibleUid) {
        this.responsibleUid = responsibleUid;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public Long getRemovedUid() {
        return removedUid;
    }

    public void setRemovedUid(Long removedUid) {
        this.removedUid = removedUid;
    }

    public BaseCollaborator getFromUser() {
        return fromUser;
    }

    public void setFromUser(BaseCollaborator fromUser) {
        this.fromUser = fromUser;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseLiveNotification that = (BaseLiveNotification) o;

        if (!notificationKey.equals(that.notificationKey)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return notificationKey.hashCode();
    }
}
