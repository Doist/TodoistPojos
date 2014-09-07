package com.todoist.model;

public class BaseLabel extends TodoistObjectWithId implements Comparable<BaseLabel> {
    public static final String[] COLORS = Colors.LABEL_COLORS;
    public static final int DEFAULT_COLOR = Colors.DEFAULT_LABEL_COLOR;

    private String name;
    private int color;

    public BaseLabel(long id, String name, int color, boolean deleted) {
        super(id, deleted);
        this.name = name;
        this.color = color;
    }

    public BaseLabel(long id, String name, int color) {
        this(id, name, color, false);
    }

    public BaseLabel(long id, String name) {
        this(id, name, Colors.DEFAULT_LABEL_COLOR, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public int compareTo(BaseLabel other) {
        return getId() < other.getId() ? -1 : (getId() == other.getId() ? 0 : 1);
    }
}
