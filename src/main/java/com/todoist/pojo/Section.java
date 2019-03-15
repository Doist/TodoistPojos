package com.todoist.pojo;

public class Section extends TodoistObject {
    private String name;
    private long projectId;
    private int sectionOrder;
    private boolean collapsed;
    private long dateAdded;
    private boolean archived;
    private Long dateArchived;

    public Section(long id, String name, long projectId, int sectionOrder, boolean collapsed,
                   long dateAdded, boolean archived, Long dateArchived, boolean deleted) {
        super(id, deleted);
        this.name = name;
        this.projectId = projectId;
        this.sectionOrder = sectionOrder;
        this.collapsed = collapsed;
        this.dateAdded = dateAdded;
        this.archived = archived;
        this.dateArchived = dateArchived;
    }

    public Section(long id, String name, long projectId, int sectionOrder, boolean collapsed, long dateAdded) {
        this(id, name, projectId, sectionOrder, collapsed, dateAdded, false, null, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public int getSectionOrder() {
        return sectionOrder;
    }

    public void setSectionOrder(int sectionOrder) {
        this.sectionOrder = sectionOrder;
    }

    public boolean isCollapsed() {
        return collapsed;
    }

    public void setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
    }

    public long getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(long dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Long getDateArchived() {
        return dateArchived;
    }

    public void setDateArchived(Long dateArchived) {
        this.dateArchived = dateArchived;
    }
}
