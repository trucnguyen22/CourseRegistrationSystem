package com.coursesytem.model;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class ScheduleTest {
        private Schedule schedule;
        private Course course1;
        private Course course2;
        private CourseLog courseLog;

        @Before
        public void setUp() {
            schedule = new Schedule();
            course1 = new Course("MATH101", 3);
            course2 = new Course("CHEM100", 3);
            courseLog = CourseLog.getInstance();
            courseLog.getCourses().clear();
        }

        @Test
        public void testAddCourseWhenCourseNotInLog() {
            schedule.addCourse(course1);
            Set<Course> registeredCourses = schedule.getRegisteredCourses();
            assertFalse(registeredCourses.contains(course1));
        }

        @Test
        public void testAddCourseWhenCourseInLog() {
            courseLog.getCourses().add(course2);
            schedule.addCourse(course2);
            Set<Course> registeredCourses = schedule.getRegisteredCourses();
            assertTrue(registeredCourses.contains(course2));
        }

        @Test
        public void testWeekdaysArray() {
            String[] expectedWeekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
            assertArrayEquals(expectedWeekdays, Schedule.weekdays);
        }
}
