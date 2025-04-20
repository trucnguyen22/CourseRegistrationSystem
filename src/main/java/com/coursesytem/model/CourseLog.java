package com.coursesytem.model;

import java.util.ArrayList;
import java.util.List;

public class CourseLog {

    private static CourseLog instance;
    
    private List<Course> courses;

    private CourseLog() {
        courses = new ArrayList<>();
    }

    public static CourseLog getInstance() {
        if (instance == null) {
            instance = new CourseLog();
        }
        return instance;
    }

    public List<Course> getCourses() {
        return courses;
    }
}
