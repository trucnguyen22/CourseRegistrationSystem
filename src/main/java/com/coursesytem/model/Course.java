package com.coursesytem.model;

import java.util.Objects;

// A class representing a course in the course system
public class Course {

    private String name;
    private int credit;

    public Course(String name, int credit) {
        this.name = name;
        this.credit = credit;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
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
