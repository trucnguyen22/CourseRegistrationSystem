package com.coursesytem.model;

import java.util.*;

// A class representing a student's schedule
public class Schedule {
    
    public static String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    private Set<Course> registeredCourses;
    private CourseLog courseLog;
    private Map<String, Set<ClassSection>> table;

    public Schedule() {
        registeredCourses = new HashSet<>();
        courseLog = CourseLog.getInstance();
        table = new HashMap<>();
    }

    // MODIFIES: this
    // EFFECTS: if the CourseLog contains the course, add it to the registeredCourses
    public boolean addCourse(Course course) {
        if (courseLog.getCourses().contains(course)) {
            if (registeredCourses.contains(course)) {
                return true;
            }
            registeredCourses.add(course);
            return true;
        }
        return false;
    }

    // MODIFIES: this
    // EFFECTS: if the this course can be added to the (registered) course, 
    //          add it to the (registered) course and its classSection to the schedule
    public void addClassSectionToTable(Course course, ClassSection classSection, String weekday, int startTime, int endTime) {
        if (addCourse(course) && course.getClassSections().contains(classSection)) {   
            Set<ClassSection> sections = new HashSet<>();
            if (table.containsKey(weekday)) {
                sections = table.get(weekday);
            } else {
                sections = new HashSet<>();
                table.put(weekday, sections);
            }
            classSection.addStudent();
            classSection.setStartTime(startTime);
            classSection.setEndTime(endTime);
            sections.add(classSection);
        }
    }

    // getters
    public Set<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public Set<ClassSection> getRegisteredClassSection() {
        Set<ClassSection> registeredClassSections = new HashSet<>();
        for (Course course : registeredCourses) {
            registeredClassSections.addAll(course.getClassSections());
        }
        return registeredClassSections;
    }

    public Map<String, Set<ClassSection>> getTable() {
        return table;
    }
}
