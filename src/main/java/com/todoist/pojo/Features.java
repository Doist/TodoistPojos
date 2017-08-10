package com.todoist.pojo;

public class Features {
    private String text;
    private int restriction;
    private boolean dateistInlineDisabled;
    private String dateistLang;
    private boolean goldTheme;
    private boolean autoAcceptInvitesDisabled;

    public Features(String text, int restriction, boolean dateistInlineDisabled, String dateistLang, boolean goldTheme,
                    boolean autoAcceptInvitesDisabled) {
        this.text = text;
        this.restriction = restriction;
        this.dateistInlineDisabled = dateistInlineDisabled;
        this.dateistLang = dateistLang;
        this.goldTheme = goldTheme;
        this.autoAcceptInvitesDisabled = autoAcceptInvitesDisabled;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRestriction() {
        return restriction;
    }

    public void setRestriction(int restriction) {
        this.restriction = restriction;
    }

    public boolean isDateistInlineDisabled() {
        return dateistInlineDisabled;
    }

    public void setDateistInlineDisabled(boolean dateistInlineDisabled) {
        this.dateistInlineDisabled = dateistInlineDisabled;
    }

    public String getDateistLang() {
        return dateistLang;
    }

    public void setDateistLang(String dateistLang) {
        this.dateistLang = dateistLang;
    }

    public boolean hasGoldTheme() {
        return goldTheme;
    }

    public void setHasGoldTheme(boolean goldTheme) {
        this.goldTheme = goldTheme;
    }

    public boolean isAutoAcceptInvitesDisabled() {
        return autoAcceptInvitesDisabled;
    }

    public void setAutoAcceptInvitesDisabled(boolean autoAcceptInvitesDisabled) {
        this.autoAcceptInvitesDisabled = autoAcceptInvitesDisabled;
    }
}
