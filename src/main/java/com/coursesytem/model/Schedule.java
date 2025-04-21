package com.coursesytem.model;

import java.util.*;

public class Schedule {
    public static String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    private Set<Course> registeredCourses;
    private CourseLog courseLog;

    public Schedule() {
        registeredCourses = new HashSet<>();
        courseLog = CourseLog.getInstance();
    }

    // EFFECTS: if the CourseLog contains the course, add it to the registeredCourses
    public void addCourse(Course course) {
        if (courseLog.getCourses().contains(course)) {
            registeredCourses.add(course);
        }
    }

    // getters
    public Set<Course> getRegisteredCourses() {
        return registeredCourses;
    }
}
