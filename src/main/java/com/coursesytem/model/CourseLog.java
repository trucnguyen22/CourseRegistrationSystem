package com.coursesytem.model;

import java.util.HashSet;
import java.util.Set;

// A singleton class that manages a list of courses
public class CourseLog {

    private static CourseLog instance;
    
    private Set<Course> courses;

    private CourseLog() {
        courses = new HashSet<>();
    }

    // getters
    public static CourseLog getInstance() {
        if (instance == null) {
            instance = new CourseLog();
        }
        return instance;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    // MODIFIES: this
    // EFFECTS: add a course to the list of courses 
    //          if it is not already in the list
    public void addCourse(Course course) {
        courses.add(course);
    }
}
