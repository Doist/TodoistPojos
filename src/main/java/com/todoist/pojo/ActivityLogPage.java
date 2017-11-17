package com.todoist.pojo;

import java.util.List;

public class ActivityLogPage {
    private int count;
    private List<? extends Event> events;

    public ActivityLogPage(int count, List<? extends Event> events) {
        this.count = count;
        this.events = events;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<? extends Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
