package com.todoist.pojo;

public class StatsDay {
    private String date;
    private int totalCompleted;

    public StatsDay(String date, int totalCompleted) {
        this.date = date;
        this.totalCompleted = totalCompleted;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalCompleted() {
        return totalCompleted;
    }

    public void setTotalCompleted(int totalCompleted) {
        this.totalCompleted = totalCompleted;
    }
}
