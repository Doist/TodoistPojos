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
     * Returns the color index of {@link #COLORS}.
     * If not within the available bounds, it falls back to the default color.
     */
    public int getColor() {
        if(color < 0 || color > Colors.LABEL_COLORS.length - 1) {
            return Colors.DEFAULT_LABEL_COLOR;
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
