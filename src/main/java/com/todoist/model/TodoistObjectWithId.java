package com.todoist.model;

class TodoistObjectWithId extends TodoistObject {
    private long id;

    public TodoistObjectWithId(long id, boolean deleted) {
        super(deleted);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean hasTempId() {
        return id < 0;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        return id == ((TodoistObjectWithId) other).id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
