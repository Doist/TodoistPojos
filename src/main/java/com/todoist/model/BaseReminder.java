package com.todoist.model;

public class BaseReminder extends TodoistObjectWithId {
    public static final String TYPE_ABSOLUTE = "absolute";
    public static final String TYPE_RELATIVE = "relative";
    public static final String TYPE_LOCATION = "location";

    public static final String SERVICE_EMAIL = "email";
    public static final String SERVICE_PUSH = "push";
    public static final String SERVICE_MOBILE = "mobile";
    public static final String SERVICE_NO_DEFAULT = "no_default";
    public static final String SERVICE_OTHER = "other";

    public static final String LOC_TRIGGER_ON_ENTER = "on_enter";
    public static final String LOC_TRIGGER_ON_LEAVE = "on_leave";

    private String type;
    /** Exclusive to reminders of type {@link #TYPE_ABSOLUTE}. */
    private String dateString;
    /** Exclusive to reminders of type {@link #TYPE_ABSOLUTE}. */
    private String dueDate;
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

    public BaseReminder(long id, String type, String dateString,
                        String dueDate, Integer minuteOffset, String name, Double locLat, Double locLong,
                        Integer radius, String locTrigger, Long notifyUid, long itemId, boolean deleted) {
        super(id, deleted);
        this.type = type;
        this.dateString = dateString;
        this.dueDate = dueDate;
        this.minuteOffset = minuteOffset;
        this.name = name;
        this.locLat = locLat;
        this.locLong = locLong;
        this.radius = radius;
        this.locTrigger = locTrigger;
        this.notifyUid = notifyUid;
        this.itemId = itemId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
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
}
