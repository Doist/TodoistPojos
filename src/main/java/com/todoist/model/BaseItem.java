package com.todoist.model;

import java.util.Collection;
import java.util.TreeSet;

public class BaseItem extends TodoistObject {
    public static final int MIN_INDENT = 1;
    public static final int MAX_INDENT = 5;
    public static final int MIN_PRIORITY = 1;
    public static final int MAX_PRIORITY = 4;

    private String content;
    private long projectId;
    private int priority;
    private String dateString;
    private String dateLang;
    private Long dueDate;
    private int itemOrder;
    private int indent;
    private int dayOrder;
    private boolean checked;
    private boolean collapsed;
    private Long assignedByUid;
    private Long responsibleUid;
    private boolean inHistory;
    private Collection<Long> labels = new TreeSet<>();
    private boolean archived;
    private long dateAdded;
    private boolean hasMoreNotes;

    public BaseItem(long id, String content, long projectId, int priority, String dateString, String dateLang,
                    Long dueDate, int itemOrder, int indent, int dayOrder, boolean checked, boolean collapsed,
                    Long assignedByUid, Long responsibleUid, Collection<Long> labels, boolean inHistory,
                    boolean archived, boolean deleted, long dateAdded, boolean hasMoreNotes) {
        super(id, deleted);
        this.content = content;
        this.projectId = projectId;
        this.priority = priority;
        this.dateString = dateString;
        this.dueDate = dueDate;
        this.dateLang = dateLang;
        this.itemOrder = itemOrder;
        this.indent = indent;
        this.dayOrder = dayOrder;
        this.checked = checked;
        this.collapsed = collapsed;
        this.assignedByUid = assignedByUid;
        this.responsibleUid = responsibleUid;
        if (labels != null) {
            this.labels.addAll(labels);
        }
        this.inHistory = inHistory;
        this.archived = archived;
        this.dateAdded = dateAdded;
        this.hasMoreNotes = hasMoreNotes;
    }

    public BaseItem(long id, String content, long projectId, int priority, String dateString, String dateLang,
                    Long dueDate, int itemOrder, int indent, int dayOrder, boolean checked, boolean collapsed,
                    Long assignedByUid, Long responsibleUid, Collection<Long> labels, boolean inHistory,
                    long dateAdded, boolean hasMoreNotes) {
        this(id, content, projectId, priority, dateString, dateLang, dueDate, itemOrder, indent, dayOrder, checked,
             collapsed, assignedByUid, responsibleUid, labels, inHistory, false, false, dateAdded, hasMoreNotes);
    }

    public BaseItem(long id, String content, long projectId, int priority, String dateString, String dateLang,
                    Long dueDate, int itemOrder, int indent, Long assignedByUid, Long responsibleUid,
                    Collection<Long> labels, long dateAdded) {
        this(id, content, projectId, priority, dateString, dateLang, dueDate, itemOrder, indent, -1, false, false,
             assignedByUid, responsibleUid, labels, false, false, false, dateAdded, false);
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
        return clampPriority(priority);
    }

    /**
     * Sets the priority, with the side effect of resetting the day order to its default value of -1.
     */
    public void setPriority(int priority) {
        if (priority != this.priority) {
            this.priority = priority;
            this.dayOrder = -1;
        }
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getDateLang() {
        return dateLang;
    }

    public void setDateLang(String dateLang) {
        this.dateLang = dateLang;
    }

    public Long getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date, with the side effect of resetting the day order to its default value of -1.
     */
    public void setDueDate(Long dueDate) {
        if (dueDate != this.dueDate && (dueDate == null || !dueDate.equals(this.dueDate))) {
            this.dueDate = dueDate;
            this.dayOrder = -1;
        }
    }

    public int getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(int itemOrder) {
        this.itemOrder = itemOrder;
    }

    /**
     * Returns the indent within the bounds defined by {@link #MIN_INDENT} and {@link #MAX_INDENT}.
     */
    public int getIndent() {
        return clampIndent(indent);
    }

    public void setIndent(int indent) {
        this.indent = indent;
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
     * Returns an ordered collection of label ids.
     */
    public Collection<Long> getLabels() {
        return labels;
    }

    /**
     * Sets the label ids. The internal collection is cleared and copies the elements in {@code labels}, if any.
     */
    public void setLabels(Collection<Long> labels) {
        this.labels.clear();
        if (labels != null) {
            this.labels.addAll(labels);
        }
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

    public boolean hasMoreNotes(){
        return hasMoreNotes;
    }

    public void setHasMoreNotes(boolean hasMoreNotes){
        this.hasMoreNotes = hasMoreNotes;
    }
    /**
     * Returns {@code priority} within the bounds defined by {@link #MIN_PRIORITY} and {@link #MAX_PRIORITY}.
     */
    public static int clampPriority(int priority) {
        return Utils.clamp(priority, MIN_PRIORITY, MAX_PRIORITY);
    }

    /**
     * Returns {@code indent} within the bounds defined by {@link #MIN_INDENT} and {@link #MAX_INDENT}.
     */
    public static int clampIndent(int indent) {
        return Utils.clamp(indent, MIN_INDENT, MAX_INDENT);
    }
}
