package com.todoist.model;

public class BaseProject extends TodoistObjectWithId {
    public static final int MIN_INDENT = 1;
    public static final int MAX_INDENT = 4;

    public static final String[] COLORS_FREE = Colors.PROJECT_COLORS_FREE;
    public static final String[] COLORS_PREMIUM = Colors.PROJECT_COLORS_PREMIUM;
    public static final int DEFAULT_COLOR = Colors.DEFAULT_PROJECT_COLOR;

    public static final int MAX_COUNT_FREE = 80;
    public static final int MAX_COUNT_PREMIUM = 200;
    public static final int MAX_ITEM_COUNT_FREE = 150;
    public static final int MAX_ITEM_COUNT_PREMIUM = 200;
    public static final int MAX_COLLABORATOR_COUNT_FREE = 6; // User + 5.
    public static final int MAX_COLLABORATORS_COUNT_PREMIUM = 26; // User + 25.

    private String name;
    private int color;
    private int indent;
    private int itemOrder;
    private boolean collapsed;
    private boolean inbox;
    private boolean teamInbox;
    private boolean shared;
    private boolean archived;

    public BaseProject(long id, String name, int color, int indent, int itemOrder, boolean collapsed,
                       boolean inbox, boolean teamInbox, boolean shared, boolean archived, boolean deleted) {
        super(id, deleted);
        this.name = sanitize(name);
        this.color = color;
        this.indent = indent;
        this.itemOrder = itemOrder;
        this.collapsed = collapsed;
        this.inbox = inbox;
        this.teamInbox = teamInbox;
        this.shared = shared;
        this.archived = archived;
    }

    public BaseProject(long id, String name, int color, int indent, int itemOrder, boolean collapsed,
                       boolean inbox, boolean teamInbox, boolean shared) {
        this(id, name, color, indent, itemOrder, collapsed, inbox, teamInbox, shared, false, false);
    }

    public BaseProject(long id, String name, int color, int indent, int itemOrder) {
        this(id, name, color, indent, itemOrder, false, false, false, false, false, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = sanitize(name);
    }

    /**
     * Returns the color index in {@link #COLORS_FREE} / {@link #COLORS_PREMIUM}.
     */
    public int getColor() {
        return color;
    }

    /**
     * Returns the color index in {@link #COLORS_FREE} / {@link #COLORS_PREMIUM} within the available bounds, which
     * depend on {@code isPremium}. If outside those bounds, the default color index is returned.
     */
    public int getColorWithinBounds(boolean isPremium) {
        if (color < 0
                || (isPremium && color > COLORS_PREMIUM.length - 1) || (!isPremium && color > COLORS_FREE.length - 1)) {
            return DEFAULT_COLOR;
        } else {
            return color;
        }
    }

    public void setColor(int color) {
        this.color = color;
    }

    /**
     * Returns the indent within the bounds defined by {@link #MIN_INDENT} and {@link #MAX_INDENT}.
     */
    public int getIndent() {
        return Utils.trim(indent, MIN_INDENT, MAX_INDENT);
    }

    public void setIndent(int indent) {
        this.indent = indent;
    }

    public int getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(int itemOrder) {
        this.itemOrder = itemOrder;
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

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    private String sanitize(String name) {
        if (name != null) {
            name = Sanitizers.PROJECT_NAME_INVALID_PATTERN.matcher(name.trim()).replaceAll("_");
        }
        return name;
    }
 }
