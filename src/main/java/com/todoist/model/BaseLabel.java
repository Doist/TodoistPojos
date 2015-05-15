package com.todoist.model;

public class BaseLabel extends TodoistObjectWithId {
    public static final String[] COLORS = Colors.LABEL_COLORS;
    public static final int DEFAULT_COLOR = Colors.DEFAULT_LABEL_COLOR;

    private String name;
    private int color;
    private int itemOrder;

    public BaseLabel(long id, String name, int color, int itemOrder, boolean deleted) {
        super(id, deleted);
        this.name = sanitize(name);
        this.color = color;
        this.itemOrder = itemOrder;
    }

    public BaseLabel(long id, String name, int color, int itemOrder) {
        this(id, name, color, itemOrder, false);
    }

    public BaseLabel(long id, String name, int itemOrder) {
        this(id, name, Colors.DEFAULT_LABEL_COLOR, itemOrder, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = sanitize(name);
    }

    /**
     * Returns the color index in {@link #COLORS}.
     */
    public int getColor() {
        return color;
    }

    /**
     * Returns the color index in {@link #COLORS} within the available bounds. If outside those bounds, the default
     * color index is returned.
     */
    public int getColorWithinBounds() {
        if(color < 0 || color > COLORS.length - 1) {
            return DEFAULT_COLOR;
        } else {
            return color;
        }
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

    private String sanitize(String name) {
        if (name != null) {
            name = Sanitizers.LABEL_NAME_INVALID_PATTERN.matcher(name.trim()).replaceAll("_");
        }
        return name;
    }
}
