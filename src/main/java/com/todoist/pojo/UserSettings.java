package com.todoist.pojo;

public class UserSettings {
    private final boolean reminderPush;
    private final boolean reminderDesktop;
    private final boolean reminderEmail;

    public UserSettings(boolean reminderPush, boolean reminderDesktop, boolean reminderEmail) {
        this.reminderPush = reminderPush;
        this.reminderDesktop = reminderDesktop;
        this.reminderEmail = reminderEmail;
    }

    public boolean getReminderPush() {
        return reminderPush;
    }

    public boolean getReminderDesktop() {
        return reminderDesktop;
    }

    public boolean getReminderEmail() {
        return reminderEmail;
    }
}
