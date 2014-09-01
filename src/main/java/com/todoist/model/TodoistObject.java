package com.todoist.model;

class TodoistObject {
    private boolean deleted;

    public TodoistObject(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
