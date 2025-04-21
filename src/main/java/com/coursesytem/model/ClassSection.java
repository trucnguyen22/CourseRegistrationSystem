package com.coursesytem.model;

// A class representing a section of a course
public class ClassSection {

    private static final int MAX_CAPACITY = 30;

    private String name;
    private int startTime;
    private int endTime;
    private int capacity;

    // REQUIRES: startTime < endTime, 0 <= startTime, endTime <= 24
    public ClassSection(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        capacity = 0;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getCapacity() {
        return capacity;
    }

    // MODIFIES: this
    // EFFECTS: if the capacity is less than MAX_CAPACITY, increase the capacity by 1
    public void addStudent() {
        if (capacity < MAX_CAPACITY) {
            capacity++;
        }
    }

    public boolean isFull() {
        return capacity >= MAX_CAPACITY;
    }
}
