package com.todoist.pojo;

import java.util.Collection;
import java.util.Set;

public class Item extends TodoistObject {
    public static final int MAX_ANCESTORS = 4;
    public static final int MIN_PRIORITY = 1;
    public static final int MAX_PRIORITY = 4;

    private String content;
    private long projectId;
    private int priority;
    private Due due;
    private Long parentId;
    private int childOrder;
    private int dayOrder;
    private boolean checked;
    private boolean collapsed;
    private Long assignedByUid;
    private Long responsibleUid;
    private boolean inHistory;
    private Set<Long> labels;
    private boolean archived;
    private long dateAdded;
    private boolean hasMoreNotes;

    public Item(long id, String content, long projectId, int priority, Due due, Long parentId, int childOrder,
                int dayOrder, boolean checked, boolean collapsed, Long assignedByUid, Long responsibleUid,
                Collection<Long> labels, boolean inHistory, boolean archived, long dateAdded, boolean hasMoreNotes,
                boolean deleted) {
        super(id, deleted);
        this.content = content;
        this.projectId = projectId;
        this.priority = priority;
        this.due = due;
        this.parentId = parentId;
        this.childOrder = childOrder;
        this.dayOrder = dayOrder;
        this.checked = checked;
        this.collapsed = collapsed;
        this.assignedByUid = assignedByUid;
        this.responsibleUid = responsibleUid;
        this.labels = Utils.unmodifiableSet(labels);
        this.inHistory = inHistory;
        this.archived = archived;
        this.dateAdded = dateAdded;
        this.hasMoreNotes = hasMoreNotes;
    }

    public Item(long id, String content, long projectId, int priority, Due due, Long parentId, int childOrder,
                int dayOrder, boolean checked, boolean collapsed, Long assignedByUid, Long responsibleUid,
                Collection<Long> labels, boolean inHistory, long dateAdded, boolean hasMoreNotes) {
        this(id, content, projectId, priority, due, parentId, childOrder, dayOrder, checked, collapsed, assignedByUid,
             responsibleUid, labels, inHistory, false, dateAdded, hasMoreNotes, false);
    }

    public Item(long id, String content, long projectId, int priority, Due due, Long parentId, int childOrder,
                Long assignedByUid, Long responsibleUid, Collection<Long> labels, long dateAdded) {
        this(id, content, projectId, priority, due, parentId, childOrder, -1, false, false, assignedByUid, responsibleUid,
             labels, false, false, dateAdded, false, false);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    /**
     * Returns the priority within the bounds defined by {@link #MIN_PRIORITY} and {@link #MAX_PRIORITY}.
     */
    public int getPriority() {
        return Utils.clamp(priority, MIN_PRIORITY, MAX_PRIORITY);
    }

    /**
     * Sets the priority, with the side effect of resetting the day order to its default value of -1.
     */
    public void setPriority(int priority) {
        if (priority != this.priority) {
            this.priority = priority;
            setDayOrder(-1);
        }
    }

    public Due getDue() {
        return due;
    }

    /**
     * Sets the due date, with the side effect of resetting the day order to its default value of -1.
     */
    public void setDue(Due due) {
        if (!Utils.equals(due, this.due)) {
            this.due = due;
            setDayOrder(-1);
        }
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public int getChildOrder() {
        return childOrder;
    }

    public void setChildOrder(int childOrder) {
        this.childOrder = childOrder;
    }

    public int getDayOrder() {
        return dayOrder;
    }

    public void setDayOrder(int dayOrder) {
        this.dayOrder = dayOrder;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isCollapsed() {
        return collapsed;
    }

    public void setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
    }

    public Long getAssignedByUid() {
        return assignedByUid;
    }

    public void setAssignedByUid(Long assignedByUid) {
        this.assignedByUid = assignedByUid;
    }

    public Long getResponsibleUid() {
        return responsibleUid;
    }

    public void setResponsibleUid(Long responsibleUid) {
        this.responsibleUid = responsibleUid;
    }

    /**
     * @return Unmodifiable set of label ids.
     */
    public Set<Long> getLabels() {
        return labels;
    }

    /**
     * Copies the label ids into an unmodifiable set.
     */
    public void setLabels(Collection<Long> labels) {
        this.labels = Utils.unmodifiableSet(labels);
    }

    public boolean isInHistory() {
        return inHistory;
    }

    public void setInHistory(boolean inHistory) {
        this.inHistory = inHistory;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean hasMoreNotes() {
        return hasMoreNotes;
    }

    public void setHasMoreNotes(boolean hasMoreNotes) {
        this.hasMoreNotes = hasMoreNotes;
    }
}
