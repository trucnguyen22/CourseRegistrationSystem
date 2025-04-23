package com.coursesytem.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CourseLogTest {
    private CourseLog courseLog;

    @Before
    public void setUp() {
        courseLog = CourseLog.getInstance();
        courseLog.clearCourses();
    }

    @Test
    public void testSingleton() {
        CourseLog anotherCourseLog = CourseLog.getInstance();
        assertSame(courseLog, anotherCourseLog);
    }

    @Test
    public void testAddCourse() {
        Course course = new Course("MATH100", 3);
        courseLog.addCourse(course);
        assertTrue(CourseLog.getInstance().getCourses().contains(course));

        Course course2 = new Course("BIO101", 3);
        courseLog.addCourse(course2);
        assertTrue(CourseLog.getInstance().getCourses().contains(course2));
    }

    @Test
    public void testAddDuplicateCourse() {
        Course course1 = new Course("MATH100", 3);
        Course course2 = new Course("MATH100", 3);
        courseLog.addCourse(course1);
        courseLog.addCourse(course2);
        assertEquals(1, courseLog.getCourses().size());
    }
}
