package com.todoist.pojo;

public class Label extends TodoistObject {
    public static final int[] COLORS = {
            Colors.FOREST,
            Colors.OLIVE,
            Colors.TOMATO,
            Colors.MAGENTA,
            Colors.GRAPE,
            Colors.PEACOCK,
            Colors.SEA,
            Colors.CHARCOAL,
            Colors.LAGOON,
            Colors.TEAL,
            Colors.CRIMSON,
            Colors.EMERALD,
            Colors.NIGHT,
    };
    public static final int DEFAULT_COLOR = 7;

    public static final int MAX_COUNT = 500;

    private String name;
    private int color;
    private int itemOrder;

    public Label(long id, String name, int color, int itemOrder, boolean deleted) {
        super(id, deleted);
        this.name = sanitizeName(name);
        this.color = color;
        this.itemOrder = itemOrder;
    }

    public Label(long id, String name, int color, int itemOrder) {
        this(id, name, color, itemOrder, false);
    }

    public Label(long id, String name, int itemOrder) {
        this(id, name, DEFAULT_COLOR, itemOrder, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = sanitizeName(name);
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

    /**
     * Returns the color value of the bounded color {@link #getColorWithinBounds() index}.
     */
    public int getColorInt() {
        return COLORS[getColorWithinBounds()];
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

    public static String sanitizeName(String name) {
        if (name != null) {
            name = Sanitizers.LABEL_NAME_INVALID_PATTERN.matcher(name.trim()).replaceAll(Sanitizers.REPLACEMENT);
        }
        return name;
    }
}
