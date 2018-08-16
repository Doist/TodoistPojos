package com.todoist.pojo;

public class Label extends TodoistObject {
    public static final int MAX_COUNT = 500;

    private String name;
    private int color;
    private int itemOrder;
    private boolean favorite;

    public Label(long id, String name, int color, int itemOrder, boolean favorite, boolean deleted) {
        super(id, deleted);
        this.name = sanitizeName(name);
        this.color = color;
        this.itemOrder = itemOrder;
        this.favorite = favorite;
    }

    public Label(long id, String name, int color, int itemOrder, boolean favorite) {
        this(id, name, color, itemOrder, favorite, false);
    }

    public Label(long id, String name, int itemOrder, boolean favorite) {
        this(id, name, Colors.DEFAULT_COLOR_ID, itemOrder, favorite, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = sanitizeName(name);
    }

    public int getColor() {
        return color;
    }

    public int getColorInt() {
        return Colors.getColorIntForId(color);
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

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public static String sanitizeName(String name) {
        if (name != null) {
            name = Sanitizers.LABEL_NAME_INVALID_PATTERN.matcher(name.trim()).replaceAll(Sanitizers.REPLACEMENT);
        }
        return name;
    }
}
