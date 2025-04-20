package com.coursesytem.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CourseTest {
    private Course course1;
    private Course course2;

    @Before
    public void setUp() {
        course1 = new Course("MATH100", 3);
        course2 = new Course("CPSC110", 4);
    }

    @Test
    public void testConstructor() {
        assertEquals("MATH100", course1.getName());
        assertEquals(3, course1.getCredit());
        assertEquals(0, course1.getCurrentCapacity());

        assertEquals("CPSC110", course2.getName());
        assertEquals(4, course2.getCredit());
        assertEquals(0, course2.getCurrentCapacity());
    }
}
