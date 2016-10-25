package com.todoist.model;

public class BaseProject extends TodoistObject {
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
    public static final int MAX_COLLABORATOR_COUNT_FREE = 5;
    public static final int MAX_COLLABORATORS_COUNT_PREMIUM = 25;

    private String name;
    private int color;
    private int itemOrder;
    private int indent;
    private boolean collapsed;
    private boolean inbox;
    private boolean teamInbox;
    private boolean shared;
    private boolean archived;
    private boolean hasMoreNotes;

    public BaseProject(long id, String name, int color, int itemOrder, int indent, boolean collapsed,
                       boolean inbox, boolean teamInbox, boolean shared, boolean archived, boolean deleted, boolean hasMoreNotes) {
        super(id, deleted);
        this.name = sanitizeName(name);
        this.color = color;
        this.itemOrder = itemOrder;
        this.indent = indent;
        this.collapsed = collapsed;
        this.inbox = inbox;
        this.teamInbox = teamInbox;
        this.shared = shared;
        this.archived = archived;
        this.hasMoreNotes = hasMoreNotes;
    }

    public BaseProject(long id, String name, int color, int itemOrder, int indent, boolean collapsed,
                       boolean inbox, boolean teamInbox, boolean shared, boolean hasMoreNotes) {
        this(id, name, color, itemOrder, indent, collapsed, inbox, teamInbox, shared, false, false, hasMoreNotes);
    }

    public BaseProject(long id, String name, int color, int itemOrder, int indent) {
        this(id, name, color, itemOrder, indent, false, false, false, false, false, false, false);
    }

    public BaseProject(long id, String name, int itemOrder) {
        this(id, name, DEFAULT_COLOR, itemOrder, MIN_INDENT, false, false, false, false, false, false, false);
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

    public boolean hasMoreNotes(){
        return hasMoreNotes;
    }

    public void setHasMoreNotes(boolean hasMoreNotes){
        this.hasMoreNotes = hasMoreNotes;
    }

    public static String sanitizeName(String name) {
        if (name != null) {
            name = Sanitizers.PROJECT_NAME_INVALID_PATTERN.matcher(name.trim()).replaceAll(Sanitizers.REPLACEMENT);
        }
        return name;
    }

    /**
     * Returns {@code indent} within the bounds defined by {@link #MIN_INDENT} and {@link #MAX_INDENT}.
     */
    public static int clampIndent(int indent) {
        return Utils.clamp(indent, MIN_INDENT, MAX_INDENT);
    }
}
