package com.coursesytem.model;

import java.util.*;

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

    // setters

    // REQUIRES: 0 <= startTime <= 24
    // MODIFIES: this
    public int setStartTime(int startTime) {
        this.startTime = startTime;
        return this.startTime;
    }

    // REQUIRES: 0 <= endTime <= 24
    // MODIFIES: this
    public int setEndTime(int endTime) {
        this.endTime = endTime;
        return this.endTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassSection that = (ClassSection) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
