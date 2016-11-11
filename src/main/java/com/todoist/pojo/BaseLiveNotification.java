package com.todoist.pojo;

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
    public static final String TYPE_KARMA_LEVEL = "karma_level";

    public static final String TYPE_BIZ_POLICY_DISALLOWED_INVITATION = "biz_policy_disallowed_invitation";
    public static final String TYPE_BIZ_POLICY_REJECTED_INVITATION = "biz_policy_rejected_invitation";
    public static final String TYPE_BIZ_TRIAL_WILL_END = "biz_trial_will_end";
    public static final String TYPE_BIZ_PAYMENT_FAILED = "biz_payment_failed";
    public static final String TYPE_BIZ_ACCOUNT_DISABLED = "biz_account_disabled";
    public static final String TYPE_BIZ_INVITATION_CREATED = "biz_invitation_created";
    public static final String TYPE_BIZ_INVITATION_ACCEPTED = "biz_invitation_accepted";
    public static final String TYPE_BIZ_INVITATION_REJECTED = "biz_invitation_rejected";

    public static final String STATE_INVITED = "invited";
    public static final String STATE_ACCEPTED = "accepted";
    public static final String STATE_REJECTED = "rejected";

    private String notificationType;
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

    // Optional fields used in Karma notifications (which are set depends on the karma level).
    private Integer karmaLevel;
    private Integer completedTasks;
    private Integer completedInDays;
    private Integer completedLastMonth;
    private Double topProcent;
    private Long dateReached;
    private String promoImg;

    public BaseLiveNotification(long id, String notificationType, long created, Long fromUid, Long projectId,
                                String projectName, Long invitationId, String invitationSecret, String state,
                                Long itemId, String itemContent, Long responsibleUid, Long noteId, String noteContent,
                                Long removedUid, BaseCollaborator fromUser, String accountName, Integer karmaLevel,
                                Integer completedTasks, Integer completedInDays, Integer completedLastMonth,
                                Double topProcent, Long dateReached, String promoImg, boolean deleted) {
        super(id, deleted);
        this.notificationType = notificationType;
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
        this.karmaLevel = karmaLevel;
        this.completedTasks = completedTasks;
        this.completedInDays = completedInDays;
        this.completedLastMonth = completedLastMonth;
        this.topProcent = topProcent;
        this.dateReached = dateReached;
        this.promoImg = promoImg;
    }

    public boolean isInvitation() {
        return Utils.equals(notificationType, TYPE_SHARE_INVITATION_SENT) ||
               Utils.equals(notificationType, TYPE_BIZ_INVITATION_CREATED);
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
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

    public Integer getKarmaLevel() {
        return karmaLevel;
    }

    public void setKarmaLevel(Integer karmaLevel) {
        this.karmaLevel = karmaLevel;
    }

    public Integer getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(Integer completedTasks) {
        this.completedTasks = completedTasks;
    }

    public Integer getCompletedInDays() {
        return completedInDays;
    }

    public void setCompletedInDays(Integer completedInDays) {
        this.completedInDays = completedInDays;
    }

    public Integer getCompletedLastMonth() {
        return completedLastMonth;
    }

    public void setCompletedLastMonth(Integer completedLastMonth) {
        this.completedLastMonth = completedLastMonth;
    }

    public Double getTopProcent() {
        return topProcent;
    }

    public void setTopProcent(Double topProcent) {
        this.topProcent = topProcent;
    }

    public Long getDateReached() {
        return dateReached;
    }

    public void setDateReached(Long dateReached) {
        this.dateReached = dateReached;
    }

    public String getPromoImg() {
        return promoImg;
    }

    public void setPromoImg(String promoImg) {
        this.promoImg = promoImg;
    }
}
