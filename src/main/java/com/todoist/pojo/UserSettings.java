package com.todoist.pojo;

public class UserSettings {
    private final boolean reminderPush;
    private final boolean reminderDesktop;
    private final boolean reminderEmail;
    private final boolean reminderSms;

    public UserSettings(boolean reminderPush, boolean reminderDesktop, boolean reminderEmail, boolean reminderSms) {
        this.reminderPush = reminderPush;
        this.reminderDesktop = reminderDesktop;
        this.reminderEmail = reminderEmail;
        this.reminderSms = reminderSms;
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

    public boolean getReminderSms() {
        return reminderSms;
    }
}
