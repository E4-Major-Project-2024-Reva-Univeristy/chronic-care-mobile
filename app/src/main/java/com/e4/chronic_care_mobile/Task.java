package com.e4.chronic_care_mobile;

import java.util.List;

public class Task {
    private final String name;
    private final int currentStreak;
    private final List<Boolean> lastSevenDays;

    public Task(String name, int currentStreak, List<Boolean> lastSevenDays) {
        this.name = name;
        this.currentStreak = currentStreak;
        this.lastSevenDays = lastSevenDays;
    }

    public String getName() { return name; }
    public int getCurrentStreak() { return currentStreak; }
    public List<Boolean> getLastSevenDays() { return lastSevenDays; }
}