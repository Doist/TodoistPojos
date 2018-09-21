package com.todoist.pojo;

public class Filter extends TodoistObject {
    public static final int MAX_COUNT = 150;

    private String name;
    private int color;
    private String query;
    private int itemOrder;
    private boolean favorite;

    public Filter(long id, String name, int color, String query, int itemOrder, boolean favorite, boolean deleted) {
        super(id, deleted);
        this.name = sanitizeName(name);
        this.color = color;
        this.query = query;
        this.itemOrder = itemOrder;
        this.favorite = favorite;
    }

    public Filter(long id, String name, int color, String query, int itemOrder, boolean favorite) {
        this(id, name, color, query, itemOrder, favorite, false);
    }

    public Filter(long id, String name, String query, int itemOrder, boolean favorite) {
        this(id, name, Colors.DEFAULT_COLOR_ID, query, itemOrder, favorite, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public int getColorInt() {
        return Colors.getColor(color);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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
            name = Sanitizers.FILTER_NAME_INVALID_PATTERN.matcher(name.trim()).replaceAll(Sanitizers.REPLACEMENT);
        }
        return name;
    }
}
