package com.coursesytem.model;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

class ClassSectionTest {

    @Test
    void testConstructor() {
        ClassSection section = new ClassSection("MATH100", 9, 11);
        assertEquals("MATH100", section.getName());
        assertEquals(9, section.getStartTime());
        assertEquals(11, section.getEndTime());
        assertEquals(0, section.getCapacity());
    }

    @Test
    void testAddStudent() {
        ClassSection section = new ClassSection("MATH100", 9, 11);
        section.addStudent();
        assertEquals(1, section.getCapacity());
    }

    @Test
    void testAddStudentMaxCapacity() {
        ClassSection section = new ClassSection("MATH100", 9, 11);
        for (int i = 0; i < 30; i++) {
            section.addStudent();
        }
        assertEquals(30, section.getCapacity());
        section.addStudent();
        assertEquals(30, section.getCapacity());
    }

    @Test
    void testIsFull() {
        ClassSection section = new ClassSection("MATH100", 9, 11);
        assertFalse(section.isFull());
        for (int i = 0; i < 30; i++) {
            section.addStudent();
        }
        assertTrue(section.isFull());
    }
}