package com.todoist.pojo;

public class Project extends TodoistObject {
    public static final int MIN_INDENT = 1;
    public static final int MAX_INDENT = 4;

    public static final int MAX_COUNT_FREE = 80;
    public static final int MAX_COUNT_PREMIUM = 300;
    public static final int MAX_COUNT_BUSINESS = 500;
    public static final int MAX_ITEM_COUNT_FREE = 150;
    public static final int MAX_ITEM_COUNT_PREMIUM = 200;
    public static final int MAX_COLLABORATOR_COUNT_FREE = 5;
    public static final int MAX_COLLABORATORS_COUNT_PREMIUM = 25;
    public static final int MAX_COLLABORATORS_COUNT_BUSINESS = 50;

    private String name;
    private int color;
    private int itemOrder;
    private int indent;
    private boolean collapsed;
    private boolean inbox;
    private boolean teamInbox;
    private boolean hasMoreNotes;
    private boolean shared;
    private boolean favorite;
    private boolean archived;

    public Project(long id, String name, int color, int itemOrder, int indent, boolean collapsed, boolean inbox,
                   boolean teamInbox, boolean hasMoreNotes, boolean shared, boolean favorite, boolean archived,
                   boolean deleted) {
        super(id, deleted);
        this.name = sanitizeName(name);
        this.color = color;
        this.itemOrder = itemOrder;
        this.indent = indent;
        this.collapsed = collapsed;
        this.inbox = inbox;
        this.teamInbox = teamInbox;
        this.hasMoreNotes = hasMoreNotes;
        this.shared = shared;
        this.favorite = favorite;
        this.archived = archived;
    }

    public Project(long id, String name, int color, int itemOrder, int indent, boolean collapsed,
                   boolean inbox, boolean teamInbox, boolean hasMoreNotes, boolean shared, boolean favorite) {
        this(id, name, color, itemOrder, indent, collapsed, inbox, teamInbox, hasMoreNotes, shared, favorite, false,
             false);
    }

    public Project(long id, String name, int color, int itemOrder, int indent, boolean favorite) {
        this(id, name, color, itemOrder, indent, false, false, false, false, false, favorite, false, false);
    }

    public Project(long id, String name, int itemOrder) {
        this(id, name, Colors.DEFAULT_COLOR_ID, itemOrder, MIN_INDENT, false, false, false, false, false, false, false, false);
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
        return Utils.clamp(indent, MIN_INDENT, MAX_INDENT);
    }

    public void setIndent(int indent) {
        this.indent = indent;
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

    public boolean hasMoreNotes() {
        return hasMoreNotes;
    }

    public void setHasMoreNotes(boolean hasMoreNotes) {
        this.hasMoreNotes = hasMoreNotes;
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
