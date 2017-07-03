package com.todoist.pojo;

public class Due {
    private String date;
    private String timezone;
    private String string;
    private String lang;
    private boolean isRecurring;

    public Due(String date, String timezone, String string, String lang, boolean isRecurring) {
        this.date = date;
        this.timezone = timezone;
        this.string = string;
        this.lang = lang;
        this.isRecurring = isRecurring;
    }

    public String getDate() {
        return date;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getString() {
        return string;
    }

    public String getLang() {
        return lang;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Due d = (Due) o;
        return Utils.equals(date, d.date) && Utils.equals(timezone, d.timezone) && Utils.equals(string, d.string) &&
                Utils.equals(lang, d.lang) && isRecurring == d.isRecurring;
    }

    @Override
    public int hashCode() {
        int hash = 23;
        hash = 31 * hash + (date != null ? date.hashCode() : 0);
        hash = 31 * hash + (timezone != null ? timezone.hashCode() : 0);
        hash = 31 * hash + (string != null ? string.hashCode() : 0);
        hash = 31 * hash + (lang != null ? lang.hashCode() : 0);
        hash = 31 * hash + (isRecurring ? 1231 : 1237);
        return hash;
    }
}
