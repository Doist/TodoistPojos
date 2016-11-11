package com.todoist.model;

public class BaseTzInfo {
    private String text;
    private String timezone;
    private int minutes;
    private int hours;
    private boolean isDst;
    private String gmtString;

    public BaseTzInfo(String text, String timezone, int minutes, int hours, boolean isDst, String gmtString) {
        this.text = text;
        this.timezone = timezone;
        this.minutes = minutes;
        this.hours = hours;
        this.isDst = isDst;
        this.gmtString = gmtString;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public boolean isDst() {
        return isDst;
    }

    public void setDst(boolean dst) {
        isDst = dst;
    }

    public String getGmtString() {
        return gmtString;
    }

    public void setGmtString(String gmtString) {
        this.gmtString = gmtString;
    }
}
