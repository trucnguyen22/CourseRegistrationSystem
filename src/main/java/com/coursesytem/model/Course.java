package com.coursesytem.model;

import java.util.Objects;

// A class representing a course in the course system
public class Course {

    private static final int MAX_CAPACITY = 30;

    private String name;
    private int credit;
    private int curCapacity;

    public Course(String name, int credit) {
        this.name = name;
        this.credit = credit;
        curCapacity = 0;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public int getCurrentCapacity() {
        return curCapacity;
    }

    @Override 
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return name.equals(course.name);
    }

    @Override 
    public int hashCode() {
        return Objects.hash(name);
    }
}
