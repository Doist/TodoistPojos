package com.todoist.pojo;

public class Project extends TodoistObject {
    public static final int MAX_DEPTH = 3;

    public static final int MAX_COUNT_FREE = 80;
    public static final int MAX_COUNT_PREMIUM = 300;
    public static final int MAX_COUNT_BUSINESS = 500;
    public static final int MAX_SECTION_COUNT = 10;
    public static final int MAX_ITEM_COUNT_FREE = 150;
    public static final int MAX_ITEM_COUNT_PREMIUM = 300;
    public static final int MAX_COLLABORATOR_COUNT_FREE = 5;
    public static final int MAX_COLLABORATORS_COUNT_PREMIUM = 25;
    public static final int MAX_COLLABORATORS_COUNT_BUSINESS = 50;

    private String name;
    private int color;
    private Long parentId;
    private int childOrder;
    private boolean collapsed;
    private boolean inbox;
    private boolean teamInbox;
    private boolean shared;
    private boolean favorite;
    private boolean archived;

    public Project(long id, String name, int color, Long parentId, int childOrder, boolean collapsed, boolean inbox,
                   boolean teamInbox, boolean shared, boolean favorite, boolean archived,
                   boolean deleted) {
        super(id, deleted);
        this.name = sanitizeName(name);
        this.color = color;
        this.parentId = parentId;
        this.childOrder = childOrder;
        this.collapsed = collapsed;
        this.inbox = inbox;
        this.teamInbox = teamInbox;
        this.shared = shared;
        this.favorite = favorite;
        this.archived = archived;
    }

    public Project(long id, String name, int color, Long parentId, int childOrder, boolean collapsed, boolean inbox,
                   boolean teamInbox, boolean shared, boolean favorite) {
        this(id, name, color, parentId, childOrder, collapsed, inbox, teamInbox, shared, favorite, false, false);
    }

    public Project(long id, String name, int color, Long parentId, int childOrder, boolean favorite) {
        this(id, name, color, parentId, childOrder, false, false, false, false, favorite, false, false);
    }

    public Project(long id, String name, int childOrder) {
        this(id, name, Colors.DEFAULT_COLOR_ID, null, childOrder, false, false, false, false, false, false, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = sanitizeName(name);
    }

    /**
     * Returns the color id.
     */
    public int getColor() {
        return color;
    }

    /**
     * Returns the color value.
     */
    public int getColorInt() {
        return Colors.getColor(color);
    }

    public void setColor(int color) {
        this.color = color;
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

    public boolean isCollapsed() {
        return collapsed;
    }

    public void setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
    }

    public boolean isInbox() {
        return inbox;
    }

    public void setInbox(boolean inbox) {
        this.inbox = inbox;
    }

    public boolean isTeamInbox() {
        return teamInbox;
    }

    public void setTeamInbox(boolean teamInbox) {
        this.teamInbox = teamInbox;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public static String sanitizeName(String name) {
        if (name != null) {
            name = Sanitizers.PROJECT_NAME_INVALID_PATTERN.matcher(name.trim()).replaceAll(Sanitizers.REPLACEMENT);
        }
        return name;
    }
}
