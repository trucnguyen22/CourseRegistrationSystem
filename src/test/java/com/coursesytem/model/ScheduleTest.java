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
        private ClassSection classSection;
        private ClassSection classSection2;

        @Before
        public void setUp() {
            schedule = new Schedule();
            course1 = new Course("MATH101", 3);
            course2 = new Course("CHEM100", 3);
            classSection = new ClassSection("MATH100-A01", 9, 11);
            classSection2 = new ClassSection("CHEM100-B01", 15, 17);
            courseLog = CourseLog.getInstance();
            courseLog.getCourses().clear();
        }

        @Test
        public void testAddCourseWhenCourseNotInLog() {
            assertFalse(schedule.addCourse(course1));
            Set<Course> registeredCourses = schedule.getRegisteredCourses();
            assertFalse(registeredCourses.contains(course1));
        }

        @Test
        public void testAddCourseWhenCourseInLog() {
            courseLog.getCourses().add(course2);
            assertTrue(schedule.addCourse(course2));
            Set<Course> registeredCourses = schedule.getRegisteredCourses();
            assertTrue(registeredCourses.contains(course2));
        }

        @Test
        public void testWeekdaysArray() {
            String[] expectedWeekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
            assertArrayEquals(expectedWeekdays, Schedule.weekdays);
        }

        @Test
        public void testAddClassSectionToTable() {
            courseLog.getCourses().add(course1);
            course1.addClassSection(classSection);
            schedule.addClassSectionToTable(course1, classSection, "Monday", 9, 11);

            Set<ClassSection> sections = schedule.getRegisteredClassSection();
            assertTrue(sections.contains(classSection));

            Map<String, Set<ClassSection>> table = schedule.getTable();
            assertTrue(table.containsKey("Monday"));
            assertTrue(table.get("Monday").contains(classSection));

            courseLog.getCourses().add(course2);
            course2.addClassSection(classSection2);
            schedule.addClassSectionToTable(course2, classSection2, "Monday", 15, 17);
            sections = schedule.getRegisteredClassSection();
            assertTrue(sections.contains(classSection));
            assertTrue(sections.contains(classSection2));

            ClassSection classSectionMATH2 = new ClassSection("MATH100-A02", 13, 15);
            course1.addClassSection(classSectionMATH2);
            schedule.addClassSectionToTable(course1, classSectionMATH2, "Monday", 13, 15);
            sections = schedule.getRegisteredClassSection();
            assertTrue(sections.contains(classSection));
            assertTrue(sections.contains(classSection2));
            assertTrue(sections.contains(classSectionMATH2));
        }

        @Test
        public void testAddClassSectionToTableWhenCourseNotInLog() {
            schedule.addClassSectionToTable(course1, classSection, "Monday", 9, 11);

            Set<ClassSection> sections = schedule.getRegisteredClassSection();
            assertFalse(sections.contains(classSection));

            Map<String, Set<ClassSection>> table = schedule.getTable();
            assertFalse(table.containsKey("Monday"));

            courseLog.getCourses().add(course1);
            course1.addClassSection(classSection);
            ClassSection classSectionMATH2 = new ClassSection("MATH100-A02", 13, 15);
            schedule.addClassSectionToTable(course1, classSectionMATH2, "Monday", 13, 15);
            sections = schedule.getRegisteredClassSection();
            assertFalse(sections.contains(classSectionMATH2));
        }
}
