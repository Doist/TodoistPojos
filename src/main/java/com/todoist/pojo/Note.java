package com.todoist.pojo;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Note extends TodoistObject {
    private String content;
    private long posted;
    private long postedUid;
    private Set<Long> uidsToNotify;
    private FileAttachment fileAttachment;
    private Map<String, long[]> reactions;
    private long projectId;
    private long itemId;
    private boolean archived;

    public Note(long id, String content, long posted, long postedUid, Collection<Long> uidsToNotify,
                FileAttachment fileAttachment, Map<String, long[]> reactions, long projectId, long itemId,
                boolean archived, boolean deleted) {
        super(id, deleted);
        this.content = content;
        this.posted = posted;
        this.postedUid = postedUid;
        this.uidsToNotify = Utils.unmodifiableSet(uidsToNotify);
        this.reactions = Utils.unmodifiableMap(reactions);
        this.fileAttachment = fileAttachment;
        this.projectId = projectId;
        this.itemId = itemId;
        this.archived = archived;
    }

    public Note(long id, String content, long posted, long postedUid, Collection<Long> uidsToNotify,
                FileAttachment fileAttachment, long projectId, long itemId) {
        this(id, content, posted, postedUid, uidsToNotify, fileAttachment, null, projectId, itemId, false, false);
    }

    public Note(long id, String content, long postedUid, Collection<Long> uidsToNotify,
                FileAttachment fileAttachment, long projectId, long itemId) {
        this(id, content, System.currentTimeMillis(), postedUid, uidsToNotify, fileAttachment, null, projectId, itemId,
             false, false);
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

    /**
     * @return Unmodifiable set of label ids.
     */
    public Set<Long> getUidsToNotify() {
        return uidsToNotify;
    }

    /**
     * Copies the user ids to notify into an unmodifiable set.
     */
    public void setUidsToNotify(Collection<Long> uidsToNotify) {
        this.uidsToNotify = Utils.unmodifiableSet(uidsToNotify);
    }

    public FileAttachment getFileAttachment() {
        return fileAttachment;
    }

    public void setFileAttachment(FileAttachment fileAttachment) {
        this.fileAttachment = fileAttachment;
    }


    public Map<String, long[]> getReactions() {
        return reactions;
    }

    public void setReactions(Map<String, long[]> reactions) {
        this.reactions = Utils.unmodifiableMap(reactions);
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
