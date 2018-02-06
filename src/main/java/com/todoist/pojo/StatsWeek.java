package com.todoist.pojo;

public class StatsWeek {
    private String from;
    private String to;
    private int totalCompleted;

    public StatsWeek(String from, String to, int totalCompleted) {
        this.from = from;
        this.to = to;
        this.totalCompleted = totalCompleted;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getTotalCompleted() {
        return totalCompleted;
    }

    public void setTotalCompleted(int totalCompleted) {
        this.totalCompleted = totalCompleted;
    }
}
