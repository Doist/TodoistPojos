package com.todoist.pojo;

import java.util.Set;

public class Tooltips {
    private Set<String> scheduled;
    private Set<String> seen;

    public Tooltips(Set<String> scheduled, Set<String> seen) {
        this.scheduled = scheduled;
        this.seen = seen;
    }

    public Set<String> getScheduled() {
        return scheduled;
    }

    public void setScheduled(Set<String> scheduled) {
        this.scheduled = scheduled;
    }

    public Set<String> getSeen() {
        return seen;
    }

    public void setSeen(Set<String> seen) {
        this.seen = seen;
    }
}