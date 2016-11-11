package com.todoist.pojo;

import java.util.Collection;
import java.util.HashSet;

public class BaseNote extends TodoistObject {
    private String content;
    private long posted;
    private long postedUid;
    private Collection<Long> uidsToNotify = new HashSet<>();
    private BaseFileAttachment fileAttachment;
    private long projectId;
    private long itemId;
    private boolean archived;

    public BaseNote(long id, String content, long posted, long postedUid, Collection<Long> uidsToNotify,
                    BaseFileAttachment fileAttachment, long projectId, long itemId, boolean archived, boolean deleted) {
        super(id, deleted);
        this.content = content;
        this.posted = posted;
        this.postedUid = postedUid;
        if (uidsToNotify != null) {
            this.uidsToNotify.addAll(uidsToNotify);
        }
        this.fileAttachment = fileAttachment;
        this.projectId = projectId;
        this.itemId = itemId;
        this.archived = archived;
    }

    public BaseNote(long id, String content, long posted, long postedUid, Collection<Long> uidsToNotify,
                    BaseFileAttachment fileAttachment, long projectId, long itemId) {
        this(id, content, posted, postedUid, uidsToNotify, fileAttachment, projectId, itemId, false, false);
    }

    public BaseNote(long id, String content, long postedUid, Collection<Long> uidsToNotify,
                    BaseFileAttachment fileAttachment, long projectId, long itemId) {
        this(id, content, System.currentTimeMillis(), postedUid, uidsToNotify, fileAttachment, projectId, itemId, false,
             false);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getPosted() {
        return posted;
    }

    public void setPosted(long posted) {
        this.posted = posted;
    }

    public long getPostedUid() {
        return postedUid;
    }

    public void setPostedUid(long postedUid) {
        this.postedUid = postedUid;
    }

    public Collection<Long> getUidsToNotify() {
        return uidsToNotify;
    }

    /**
     * Sets the user ids to notify. The internal collection is cleared and copies the elements in {@code uidsToNotify},
     * if any.
     */
    public void setUidsToNotify(Collection<Long> uidsToNotify) {
        this.uidsToNotify.clear();
        if (uidsToNotify != null) {
            this.uidsToNotify.addAll(uidsToNotify);
        }
    }

    public BaseFileAttachment getFileAttachment() {
        return fileAttachment;
    }

    public void setFileAttachment(BaseFileAttachment fileAttachment) {
        this.fileAttachment = fileAttachment;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
