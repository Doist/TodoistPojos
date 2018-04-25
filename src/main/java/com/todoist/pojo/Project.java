package com.todoist.pojo;

public class Project extends TodoistObject {
    public static final int MAX_ANCESTORS = 3;

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
    private Long parentId;
    private int childOrder;
    private boolean collapsed;
    private boolean inbox;
    private boolean teamInbox;
    private boolean hasMoreNotes;
    private boolean shared;
    private boolean favorite;
    private boolean archived;

    public Project(long id, String name, int color, Long parentId, int childOrder, boolean collapsed, boolean inbox,
                   boolean teamInbox, boolean hasMoreNotes, boolean shared, boolean favorite, boolean archived,
                   boolean deleted) {
        super(id, deleted);
        this.name = sanitizeName(name);
        this.color = color;
        this.parentId = parentId;
        this.childOrder = childOrder;
        this.collapsed = collapsed;
        this.inbox = inbox;
        this.teamInbox = teamInbox;
        this.hasMoreNotes = hasMoreNotes;
        this.shared = shared;
        this.favorite = favorite;
        this.archived = archived;
    }

    public Project(long id, String name, int color, Long parentId, int childOrder, boolean collapsed, boolean inbox,
                   boolean teamInbox, boolean hasMoreNotes, boolean shared, boolean favorite) {
        this(id, name, color, parentId, childOrder, collapsed, inbox, teamInbox, hasMoreNotes, shared, favorite, false,
             false);
    }

    public Project(long id, String name, int color, Long parentId, int childOrder, boolean favorite) {
        this(id, name, color, parentId, childOrder, false, false, false, false, false, favorite, false, false);
    }

    public Project(long id, String name, int childOrder) {
        this(id, name, DEFAULT_COLOR, null, childOrder, false, false, false, false, false, false, false, false);
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
