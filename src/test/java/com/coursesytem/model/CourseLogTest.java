package com.coursesytem.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CourseLogTest {
    private CourseLog courseLog;

    @Before
    public void setUp() {
        courseLog = CourseLog.getInstance();
    }

    @Test
    public void testSingleton() {
        CourseLog anotherCourseLog = CourseLog.getInstance();
        assertSame(courseLog, anotherCourseLog);
    }

    @Test
    public void testGetCourses() {
        assertNotNull(courseLog.getCourses());
        assertTrue(courseLog.getCourses().isEmpty());
    }
}
