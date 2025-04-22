package com.coursesytem.model;

import java.util.*;

// A class representing a course in the course system
public class Course {

    private String name;
    private int credit;
    private Set<ClassSection> classSections;

    public Course(String name, int credit) {
        this.name = name;
        this.credit = credit;
        classSections = new HashSet<>();
    }

    // getters
    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public Set<ClassSection> getClassSections() {
        return classSections;
    }

    // EFFECTS: add a class section to the course
    public void addClassSection(ClassSection classSection) {
        classSections.add(classSection);
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
