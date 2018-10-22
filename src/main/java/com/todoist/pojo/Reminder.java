package com.todoist.pojo;

public class Reminder extends TodoistObject {
    public static final String TYPE_ABSOLUTE = "absolute";
    public static final String TYPE_RELATIVE = "relative";
    public static final String TYPE_LOCATION = "location";

    public static final int DEFAULT_MINUTE_OFFSET = 30;

    public static final String LOC_TRIGGER_ON_ENTER = "on_enter";
    public static final String LOC_TRIGGER_ON_LEAVE = "on_leave";

    public static final int MAX_COUNT = 700;

    private String type;
    /** Exclusive to reminders of type {@link #TYPE_ABSOLUTE}. */
    private Due due;
    /** Exclusive to reminders of type {@link #TYPE_RELATIVE}. */
    private Integer minuteOffset;
    /** Exclusive to reminders of type {@link #TYPE_LOCATION}. */
    private String name;
    /** Exclusive to reminders of type {@link #TYPE_LOCATION}. */
    private Double locLat;
    /** Exclusive to reminders of type {@link #TYPE_LOCATION}. */
    private Double locLong;
    /** Exclusive to reminders of type {@link #TYPE_LOCATION}. */
    private Integer radius;
    /** Exclusive to reminders of type {@link #TYPE_LOCATION}. */
    private String locTrigger;
    private Long notifyUid;
    private long itemId;

    public Reminder(long id, String type,
                    Due due,
                    Integer minuteOffset,
                    String name, Double locLat, Double locLong, Integer radius, String locTrigger,
                    Long notifyUid, long itemId, boolean deleted) {
        super(id, deleted);
        this.type = type;
        this.due = due;
        this.minuteOffset = minuteOffset;
        this.name = name;
        this.locLat = locLat;
        this.locLong = locLong;
        this.radius = radius;
        this.locTrigger = locTrigger;
        this.notifyUid = notifyUid;
        this.itemId = itemId;
    }

    public Reminder(long id, String type,
                    Due due,
                    Integer minuteOffset,
                    String name, Double locLat, Double locLong, Integer radius, String locTrigger,
                    Long notifyUid, long itemId) {
        this(id, type, due, minuteOffset, name, locLat, locLong, radius, locTrigger, notifyUid, itemId, false);
    }

    public String getType() {
        return type;
    }

    public boolean isAbsolute() {
        return TYPE_ABSOLUTE.equals(type);
    }

    public boolean isRelative() {
        return TYPE_RELATIVE.equals(type);
    }

    public boolean isLocation() {
        return TYPE_LOCATION.equals(type);
    }

    public void setType(String type) {
        this.type = type;
    }

    public Due getDue() {
        return due;
    }

    public void setDue(Due due) {
        this.due = due;
    }

    public Integer getMinuteOffset() {
        return minuteOffset;
    }

    public void setMinuteOffset(Integer minuteOffset) {
        this.minuteOffset = minuteOffset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLocLat() {
        return locLat;
    }

    public void setLocLat(Double locLat) {
        this.locLat = locLat;
    }

    public Double getLocLong() {
        return locLong;
    }

    public void setLocLong(Double locLong) {
        this.locLong = locLong;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public String getLocTrigger() {
        return locTrigger;
    }

    public void setLocTrigger(String locTrigger) {
        this.locTrigger = locTrigger;
    }

    public Long getNotifyUid() {
        return notifyUid;
    }

    public void setNotifyUid(Long notifyUid) {
        this.notifyUid = notifyUid;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
}
