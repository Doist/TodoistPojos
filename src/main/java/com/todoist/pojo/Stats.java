package com.todoist.pojo;

import java.util.List;

public class Stats {
    private int completedCount;
    private List<StatsDay> daysItems;
    private List<StatsWeek> weekItems;

    public Stats(int completedCount, List<? extends StatsDay> daysItems, List<? extends StatsWeek> weekItems) {
        this.completedCount = completedCount;
        this.daysItems = Utils.unmodifiableList(daysItems);
        this.weekItems = Utils.unmodifiableList(weekItems);
    }

    public int getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(int completedCount) {
        this.completedCount = completedCount;
    }

    public List<? extends StatsDay> getDaysItems() {
        return daysItems;
    }

    public void setDaysItems(List<? extends StatsDay> daysItems) {
        this.daysItems = Utils.unmodifiableList(daysItems);
    }

    public List<? extends StatsWeek> getWeekItems() {
        return weekItems;
    }

    public void setWeekItems(List<? extends StatsWeek> weekItems) {
        this.weekItems = Utils.unmodifiableList(weekItems);
    }
}
