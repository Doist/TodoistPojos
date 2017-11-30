package com.todoist.pojo;

public class ExtraData {
    private String content;
    private String lastContent;
    private Long dueDate;
    private Long lastDueDate;
    private Long responsibleUid;
    private Long lastResponsibleUid;
    private String name;
    private String lastName;
    private String parentProjectName;
    private Integer parentProjectColor;
    private String parentItemContent;
    private int noteCount;

    public ExtraData(String content, String lastContent, Long dueDate, Long lastDueDate, Long responsibleUid,
                     Long lastResponsibleUid, String name, String lastName, String parentProjectName,
                     Integer parentProjectColor, String parentItemContent, int noteCount) {
        this.content = content;
        this.lastContent = lastContent;
        this.dueDate = dueDate;
        this.lastDueDate = lastDueDate;
        this.responsibleUid = responsibleUid;
        this.lastResponsibleUid = lastResponsibleUid;
        this.name = name;
        this.lastName = lastName;
        this.parentProjectName = parentProjectName;
        this.parentProjectColor = parentProjectColor;
        this.parentItemContent = parentItemContent;
        this.noteCount = noteCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLastContent() {
        return lastContent;
    }

    public void setLastContent(String lastContent) {
        this.lastContent = lastContent;
    }

    public Long getDueDate() {
        return dueDate;
    }

    public void setDueDate(Long dueDate) {
        this.dueDate = dueDate;
    }

    public Long getLastDueDate() {
        return lastDueDate;
    }

    public void setLastDueDate(Long lastDueDate) {
        this.lastDueDate = lastDueDate;
    }

    public Long getResponsibleUid() {
        return responsibleUid;
    }

    public void setResponsibleUid(Long responsibleUid) {
        this.responsibleUid = responsibleUid;
    }

    public Long getLastResponsibleUid() {
        return lastResponsibleUid;
    }

    public void setLastResponsibleUid(Long lastResponsibleUid) {
        this.lastResponsibleUid = lastResponsibleUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getParentProjectName() {
        return parentProjectName;
    }

    public void setParentProjectName(String parentProjectName) {
        this.parentProjectName = parentProjectName;
    }

    public Integer getParentProjectColor() {
        return parentProjectColor;
    }

    public void setParentProjectColor(Integer parentProjectColor) {
        this.parentProjectColor = parentProjectColor;
    }

    public String getParentItemContent() {
        return parentItemContent;
    }

    public void setParentItemContent(String parentItemContent) {
        this.parentItemContent = parentItemContent;
    }

    public int getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(int noteCount) {
        this.noteCount = noteCount;
    }
}