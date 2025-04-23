package com.coursesytem.model;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class ClassSectionTest {

    ClassSection section;
    
    @Before
    public void setUp() {
        section = new ClassSection("MATH100", 9, 11);
    }

    @Test
    public void testConstructor() {
        assertEquals("MATH100", section.getName());
        assertEquals(9, section.getStartTime());
        assertEquals(11, section.getEndTime());
        assertEquals(0, section.getCapacity());
    }

    @Test
    public void testAddStudent() {
        section.addStudent();
        assertEquals(1, section.getCapacity());
    }

    @Test
    public void testAddStudentMaxCapacity() {
        for (int i = 0; i < 30; i++) {
            section.addStudent();
        }
        assertEquals(30, section.getCapacity());
        section.addStudent();
        assertEquals(30, section.getCapacity());
    }

    @Test
    public void testIsFull() {
        assertFalse(section.isFull());
        for (int i = 0; i < 30; i++) {
            section.addStudent();
        }
        assertTrue(section.isFull());
    }

    @Test
    public void testTime() {
        assertEquals(9, section.getStartTime());
        assertEquals(11, section.getEndTime());

        section.setStartTime(15);
        section.setEndTime(17);
        assertEquals(15, section.getStartTime());
        assertEquals(17, section.getEndTime());
    }
}