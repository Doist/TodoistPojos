package com.todoist.model;

public class BaseProject extends TodoistObjectWithId {
    public static final int MIN_INDENT = 1;
    public static final int MAX_INDENT = 4;

    public static final int[] COLORS_PREMIUM = {
            Colors.LIME,
            Colors.SALMON,
            Colors.PEACH,
            Colors.CANARY,
            Colors.SLATE,
            Colors.CAFE,
            Colors.ORCHID,
            Colors.SILVER,
            Colors.CORAL,
            Colors.AMBER,
            Colors.TURQUOISE,
            Colors.AQUA,
            Colors.RASPBERRY,
            Colors.CHERRY,
            Colors.RUBY,
            Colors.PISTACHIO,
            Colors.TEAL,
            Colors.LAGOON,
            Colors.SKY,
            Colors.SAPPHIRE,
            Colors.ONYX,
            Colors.STEEL,
    };
    public static final int[] COLORS_FREE = new int[12]; // First 12 colors are free.
    static {
        System.arraycopy(COLORS_PREMIUM, 0, COLORS_FREE, 0, COLORS_FREE.length);
    }

    public static final int DEFAULT_COLOR = 7;

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
        this.name = sanitizeName(name);
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

    public BaseProject(long id, String name, int itemOrder) {
        this(id, name, DEFAULT_COLOR, MIN_INDENT, itemOrder, false, false, false, false, false, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = sanitizeName(name);
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
        if (color >= 0 && color < (isPremium ? COLORS_PREMIUM.length : COLORS_FREE.length)) {
            return color;
        } else {
            return DEFAULT_COLOR;
        }
    }

    /**
     * Returns the color value of the bounded color {@link #getColorWithinBounds(boolean) index}.
     */
    public int getColorInt(boolean isPremium) {
        int color = getColorWithinBounds(isPremium);
        return isPremium ? COLORS_PREMIUM[color] : COLORS_FREE[color];
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

    public static String sanitizeName(String name) {
        if (name != null) {
            name = Sanitizers.PROJECT_NAME_INVALID_PATTERN.matcher(name.trim()).replaceAll(Sanitizers.REPLACEMENT);
        }
        return name;
    }
}
